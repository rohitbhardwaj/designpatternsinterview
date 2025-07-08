/*  File: src/main/java/aibadcode/newinvoice/util/DataSourceFactory.java  */
package aibadcode.newinvoice.util;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * <h2>DataSourceFactory</h2>
 *
 * <p>Builds a ready-to-use {@link HikariDataSource} for the workshop code.</p>
 *
 * <p><b>Why this class exists</b></p>
 * <ul>
 *   <li><strong>SRP&nbsp;(Single-Responsibility)</strong> – It owns <em>only</em> the
 *       creation of a connection-pool; no SQL or business logic sneaks in.</li>
 *   <li><strong>DIP&nbsp;(Dependency-Inversion)</strong> – Higher-level services depend
 *       on the abstract {@link javax.sql.DataSource} interface, not on HikariCP
 *       or JDBC driver details.</li>
 * </ul>
 *
 * <h3>Behaviour</h3>
 * <ol>
 *   <li>If <code>JDBC_URL</code> <em>is present</em> in the environment, the
 *       method assumes the caller wants to connect to that database
 *       (commonly MySQL or Postgres).&nbsp;It also reads <code>DB_USER</code>
 *       and <code>DB_PASS</code>.</li>
 *   <li>If <code>JDBC_URL</code> is <em>missing</em>, it falls back to an
 *       <strong>in-memory H2</strong> database so that the workshop can run
 *       “out-of-the-box” without installing anything.</li>
 * </ol>
 *
 * <p>Both code paths return a fully initialised, 10-connection pool.</p>
 */
public final class DataSourceFactory {

    /** Utility – never instantiate. */
    private DataSourceFactory() { }

    /* ---------------------------------------------------------------------- */
    /* Public factory method                                                  */
    /* ---------------------------------------------------------------------- */

    /**
     * Build a {@link DataSource} using either environment variables (preferred
     * in production) or an H2 fallback (perfect for demos and unit tests).
     *
     * @return configured, ready-to-use {@link HikariDataSource}
     */
    public static DataSource fromEnv() {
        HikariConfig cfg = new HikariConfig();
        cfg.setMaximumPoolSize(10);
        cfg.setPoolName("billing-pool");

        String jdbcUrl = env("JDBC_URL", null);

        if (jdbcUrl == null) {
            /* -------------------------------------------------------------- *
             *  Fallback: self-contained in-memory database (H2)              *
             * -------------------------------------------------------------- */
            cfg.setJdbcUrl("jdbc:h2:mem:billing;DB_CLOSE_DELAY=-1");
            cfg.setUsername("sa");
            cfg.setPassword("");
            /* H2 driver auto-registers; no driverClassName needed           */
        } else {
            /* -------------------------------------------------------------- *
             *  Use user-supplied connection details                          *
             * -------------------------------------------------------------- */
            cfg.setJdbcUrl(jdbcUrl);
            cfg.setUsername(env("DB_USER", "root"));
            cfg.setPassword(env("DB_PASS", "password"));

            /* For old JDBC 4/Java-8 drivers we still set the class name
               explicitly to avoid ServiceLoader issues.                      */
            if (jdbcUrl.startsWith("jdbc:mysql:")) {
                cfg.setDriverClassName("com.mysql.cj.jdbc.Driver");
            }
            // Add similar branches for Postgres, Oracle, etc. if desired.
        }

        return new HikariDataSource(cfg);
    }

    /* ---------------------------------------------------------------------- */
    /* Private helpers                                                        */
    /* ---------------------------------------------------------------------- */

    /**
     * Read an environment variable, providing a default when it isn’t set or
     * is empty.
     */
    private static String env(String key, String fallback) {
        String val = System.getenv(key);
        return (val == null || val.trim().isEmpty()) ? fallback : val;
    }
}
