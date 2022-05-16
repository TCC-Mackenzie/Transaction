package tcc.bank.transaction.event;

import java.math.BigDecimal;

public class UpdateTransactionEvent {
    private Integer id;

    private Integer type;

    public UpdateTransactionEvent(Integer id, Integer type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public Integer getType() {
        return type;
    }

}
