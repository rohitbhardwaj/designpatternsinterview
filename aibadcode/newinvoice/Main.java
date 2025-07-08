/*  Main.java  */
package aibadcode.newinvoice;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import aibadcode.newinvoice.adapter.caching.InMemoryInvoiceCache;
import aibadcode.newinvoice.adapter.notification.ConsoleMailService;
import aibadcode.newinvoice.adapter.persistence.InMemoryInvoiceRepository;
import aibadcode.newinvoice.adapter.security.StaticTokenService;
import aibadcode.newinvoice.model.Invoice;
import aibadcode.newinvoice.service.InvoiceService;

/**
 * Minimal wiring class to show architecture in action.
 *
 * <p>Swap any adapter below and watch <b>Open-Closed</b> &amp;
 * <b>Dependency-Inversion</b> principles at work.</p>
 */
public final class Main {
    public static void main(String[] args) {

        InvoiceService svc = new InvoiceService(
            new InMemoryInvoiceRepository(),     // persistence
            new InMemoryInvoiceCache(),          // caching
            new ConsoleMailService(),            // notification
            new StaticTokenService()             // security
        );

        Invoice inv = new Invoice(1L, new BigDecimal("42.50"),
                                  "UNPAID", LocalDateTime.now());
        svc.createInvoice(inv);

        System.out.println("Issued token: " +
                svc.issueApiToken("client-xyz"));
        System.out.println("Unpaid invoices: " +
                svc.listUnpaid().size());
    }
}
