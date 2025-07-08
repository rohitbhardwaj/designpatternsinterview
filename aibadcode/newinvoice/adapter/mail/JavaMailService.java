/*  File: src/main/java/aibadcode/newinvoice/adapter/mail/JavaMailService.java  */
package aibadcode.newinvoice.adapter.mail;

import aibadcode.newinvoice.model.Invoice;
import aibadcode.newinvoice.port.MailService;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

/**
 * <h2>JavaMailService – SMTP Adapter</h2>
 *
 * <p>Implements {@link MailService} using Jakarta Mail.  Session is injected to
 * obey <b>DIP</b> and ease unit testing (mock Session).</p>
 */
public class JavaMailService implements MailService {

    private final Session session;
    private final String  from;

    public JavaMailService(Session session, String fromAddress) {
        this.session = session;
        this.from    = fromAddress;
    }

    @Override
    public void sendInvoiceCreated(Invoice inv) {
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("customer@example.com"));
            msg.setSubject("Invoice " + inv.getId() + " created");
            msg.setText("Amount due: " + inv.getAmount());
            Transport.send(msg);
        } catch (MessagingException ex) {
            throw new MailException("SMTP failure", ex);
        }
    }

    /** Keeps checked exception noise out of the service layer. */
    public static final class MailException extends RuntimeException {
        public MailException(String m, Throwable c){ super(m,c); }
    }
}
