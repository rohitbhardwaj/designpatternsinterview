/*  service/InvoiceService.java  */
package aibadcode.newinvoice.service;

import java.util.List;
import java.util.Objects;

import aibadcode.newinvoice.model.Invoice;
import aibadcode.newinvoice.port.InvoiceCache;
import aibadcode.newinvoice.port.InvoiceRepository;
import aibadcode.newinvoice.port.MailService;
import aibadcode.newinvoice.port.TokenService;

/**
 * <h2>InvoiceService – Use-Case Orchestrator</h2>
 *
 * <p>Coordinates the workflow of creating and querying invoices.</p>
 *
 * <h3>SOLID breakdown</h3>
 * <ul>
 *   <li><b>SRP</b> – Contains <em>only</em> business rules; no SQL, cache, or
 *       SMTP code.</li>
 *   <li><b>OCP</b> – Replace any adapter; methods here remain unchanged.</li>
 *   <li><b>DIP</b> – Depends solely on port interfaces.</li>
 * </ul>
 */
public class InvoiceService {

    private final InvoiceRepository repo;
    private final InvoiceCache      cache;
    private final MailService       mail;
    private final TokenService      tokens;

    public InvoiceService(InvoiceRepository repo,
                          InvoiceCache cache,
                          MailService mail,
                          TokenService tokens) {
        this.repo   = Objects.requireNonNull(repo);
        this.cache  = Objects.requireNonNull(cache);
        this.mail   = Objects.requireNonNull(mail);
        this.tokens = Objects.requireNonNull(tokens);
    }

    public void createInvoice(Invoice inv) {
        repo.save(inv);
        cache.put(inv);
        mail.sendInvoiceCreated(inv);   // side-effect delegated out
    }

    public List<Invoice> listUnpaid() {
        return repo.findUnpaid();
    }

    public String issueApiToken(String clientId) {
        return tokens.issueToken(clientId);
    }
}
