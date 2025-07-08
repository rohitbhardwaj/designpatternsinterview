/*  File: src/main/java/aibadcode/newinvoice/port/InvoiceCache.java  */
package aibadcode.newinvoice.port;

import java.util.Optional;

import aibadcode.newinvoice.model.Invoice;

/**
 * Cache abstraction.
 *
 * <p>Introduces a seam where we can plug in-memory, Redis, or a stub.</p>
 *
 * <b>SOLID</b>: SRP &amp; DIP &amp; ISP.
 */
public interface InvoiceCache {
    void put(Invoice invoice);
    Optional<Invoice> get(long id);
}
