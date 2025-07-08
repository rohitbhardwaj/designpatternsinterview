/*  File: src/main/java/aibadcode/newinvoice/port/MailService.java  */
package aibadcode.newinvoice.port;

import aibadcode.newinvoice.model.Invoice;

/**
 * Notification port.
 *
 * <h3>SOLID Call-outs</h3>
 * <ul>
 *   <li><b>ISP</b> – One small method; doesn’t grow into a “God interface”.</li>
 *   <li><b>DIP</b> – Business layer unaware of SMTP/SendGrid.</li>
 * </ul>
 */
public interface MailService {
    void sendInvoiceCreated(Invoice invoice);
}
