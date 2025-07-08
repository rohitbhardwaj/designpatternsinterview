/*  File: src/main/java/aibadcode/newinvoice/adapter/jdbc/JdbcInvoiceRepository.java  */
package aibadcode.newinvoice.adapter.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import aibadcode.newinvoice.model.Invoice;
import aibadcode.newinvoice.port.InvoiceRepository;

/**
 * <h2>JdbcInvoiceRepository – JDBC Adapter</h2>
 *
 * <p><b>Why?</b> Provides a concrete implementation of the
 * {@link InvoiceRepository} port using plain JDBC and a connection pool.
 * Keeps SQL out of the service layer.</p>
 *
 * <h3>SOLID Highlights</h3>
 * <ul>
 *   <li><b>SRP</b>: Only persistence logic lives here.</li>
 *   <li><b>OCP</b>: To switch to JPA or Mongo, introduce a new adapter;
 *       the service layer remains closed for modification.</li>
 * </ul>
 */
public class JdbcInvoiceRepository implements InvoiceRepository {

    private final DataSource ds;

    public JdbcInvoiceRepository(DataSource ds) { this.ds = ds; }

    @Override
    public void save(Invoice inv) {
        String sql = "INSERT INTO invoices (id,amount,status,created) VALUES (?,?,?,?)";
        try (Connection c = ds.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, inv.getId());
            ps.setBigDecimal(2, inv.getAmount());
            ps.setString(3, inv.getStatus());
            ps.setTimestamp(4,
                Timestamp.from(inv.getCreatedAt().toInstant(ZoneOffset.UTC)));

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new PersistenceException("save failed", ex);
        }
    }

    @Override
    public List<Invoice> findUnpaid() {
        String sql = "SELECT * FROM invoices WHERE status='UNPAID'";
        try (Connection c = ds.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            List<Invoice> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Invoice(
                       rs.getLong("id"),
                       rs.getBigDecimal("amount"),
                       rs.getString("status"),
                       rs.getTimestamp("created").toLocalDateTime()));
            }
            return list;
        } catch (SQLException ex) {
            throw new PersistenceException("read failed", ex);
        }
    }

    /** Unchecked wrapper keeps port signature free of SQL types. */
    public static final class PersistenceException extends RuntimeException {
        public PersistenceException(String msg, Throwable cause){ super(msg,cause); }
    }
}
