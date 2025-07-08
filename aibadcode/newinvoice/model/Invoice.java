/*  File: src/main/java/aibadcode/newinvoice/model/Invoice.java  */
package aibadcode.newinvoice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <h2>Invoice – Domain Entity</h2>
 *
 * <p>Pure data holder representing an invoice.  It’s intentionally
 * <em>persistence-agnostic</em>; nothing here knows about SQL, JSON, etc.</p>
 *
 * <h3>How it illustrates SOLID</h3>
 * <ul>
 *   <li><b>SRP (Single-Responsibility)</b> – Stores billing data only.</li>
 *   <li><b>LSP (Liskov Substitution)</b> – Declared {@code final}; callers
 *       can rely on its behaviour not changing via inheritance.</li>
 * </ul>
 */
public final class Invoice {

    private final long id;
    private final BigDecimal amount;
    private final String status;
    private final LocalDateTime createdAt;

    public Invoice(long id, BigDecimal amount, String status, LocalDateTime createdAt) {
        this.id        = id;
        this.amount    = Objects.requireNonNull(amount,   "amount");
        this.status    = Objects.requireNonNull(status,   "status");
        this.createdAt = Objects.requireNonNull(createdAt,"createdAt");
    }

    public long            getId()        { return id;        }
    public BigDecimal      getAmount()    { return amount;    }
    public String          getStatus()    { return status;    }
    public LocalDateTime   getCreatedAt() { return createdAt; }
}

