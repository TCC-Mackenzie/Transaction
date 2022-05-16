package tcc.bank.transaction.event;

import java.math.BigDecimal;

public class CreateTransactionEvent {
    private Integer id;

    private Integer type;

    private BigDecimal value;

    private Integer accountId;

    public CreateTransactionEvent(Integer id, Integer type, BigDecimal value, Integer accountId) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.accountId = accountId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getType() {
        return type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Integer getAccountId() {
        return accountId;
    }
}
