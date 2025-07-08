/*  adapter/persistence/InMemoryInvoiceRepository.java  */
package aibadcode.newinvoice.adapter.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aibadcode.newinvoice.model.Invoice;
import aibadcode.newinvoice.port.InvoiceRepository;

/**
 * <h2>In-Memory Repository</h2>
 *
 * <p>Concrete adapter that <em>implements</em> the
 * {@link aibadcode.newinvoice.port.InvoiceRepository InvoiceRepository} port
 * using a plain {@link HashMap}. No external libraries required.</p>
 *
 * <h3>SOLID</h3>
 * <ul>
 *   <li><b>OCP (Open-Closed)</b> – Want JDBC?  Provide another class without
 *       changing the port or the service layer.</li>
 *   <li><b>DIP</b> – Depends on domain model, not vice-versa.</li>
 * </ul>
 */
public class InMemoryInvoiceRepository implements InvoiceRepository {

    private final Map<Long, Invoice> store = new HashMap<>();

    @Override public void save(Invoice inv) { store.put(inv.getId(), inv); }

    @Override public List<Invoice> findUnpaid() {
        List<Invoice> list = new ArrayList<>();
        for (Invoice inv : store.values()) {
            if ("UNPAID".equals(inv.getStatus())) list.add(inv);
        }
        return list;
    }
}
