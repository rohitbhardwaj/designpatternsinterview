/*  adapter/notification/ConsoleMailService.java  */
package aibadcode.newinvoice.adapter.notification;

import aibadcode.newinvoice.model.Invoice;
import aibadcode.newinvoice.port.MailService;

/**
 * Sends “emails” to <i>stdout</i>.  Perfect for demos and unit tests.
 *
 * <b>OCP</b> – Swap with real SMTP adapter anytime.<br>
 * <b>SRP</b> – Only handles notification side-effect.
 */
public class ConsoleMailService implements MailService {
    @Override public void sendInvoiceCreated(Invoice inv) {
        System.out.println("[MAIL] Invoice " + inv.getId() +
                           " created for $" + inv.getAmount());
    }
}
