/*  File: src/main/java/aibadcode/newinvoice/util/JavaMailSessionFactory.java  */
package aibadcode.newinvoice.util;

import java.util.Properties;

import jakarta.mail.Session;

/** Builds a Jakarta Mail {@link Session} from env vars – again SRP. */
public final class JavaMailSessionFactory {
    public static Session fromEnv() {
        Properties p = new Properties();
        p.put("mail.smtp.host", System.getenv("SMTP_HOST"));
        p.put("mail.smtp.port", System.getenv("SMTP_PORT"));
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        return Session.getInstance(p);
    }
}
