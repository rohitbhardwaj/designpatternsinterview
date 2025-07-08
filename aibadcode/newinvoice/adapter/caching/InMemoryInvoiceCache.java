/*  adapter/caching/InMemoryInvoiceCache.java  */
package aibadcode.newinvoice.adapter.caching;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import aibadcode.newinvoice.model.Invoice;
import aibadcode.newinvoice.port.InvoiceCache;

/**
 * HashMap-based cache adapter.
 *
 * <p>Demonstrates the <em>Decorator</em> pattern conceptually (wraps data
 * behind a cache without altering repository interface).</p>
 *
 * <b>SOLID</b>: OCP (swap with Redis later) &amp; DIP.
 */
public class InMemoryInvoiceCache implements InvoiceCache {

    private final Map<Long, Invoice> cache = new HashMap<>();

    @Override public void put(Invoice inv) { cache.put(inv.getId(), inv); }

    @Override public Optional<Invoice> get(long id) {
        return Optional.ofNullable(cache.get(id));
    }
}
