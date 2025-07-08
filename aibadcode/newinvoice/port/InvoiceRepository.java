/*  File: src/main/java/aibadcode/newinvoice/port/InvoiceRepository.java  */
package aibadcode.newinvoice.port;

import java.util.List;

import aibadcode.newinvoice.model.Invoice;

/**
 * Persistence port used by the core domain.
 *
 * <h3>SOLID Focus</h3>
 * <ul>
 *   <li><b>DIP (Dependency-Inversion)</b> – High-level policy will depend on
 *       this <em>interface</em>, never on JDBC/JPA.</li>
 *   <li><b>ISP (Interface-Segregation)</b> – Only two cohesive methods.</li>
 * </ul>
 */
public interface InvoiceRepository {
    void save(Invoice invoice);
    List<Invoice> findUnpaid();
}
