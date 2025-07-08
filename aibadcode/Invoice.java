package aibadcode;

import java.math.BigDecimal;

public class Invoice {
    private final long id;
    private final BigDecimal amount;

    public Invoice(long id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public long id()          { return id;     }
    public BigDecimal amount(){ return amount; }
}

