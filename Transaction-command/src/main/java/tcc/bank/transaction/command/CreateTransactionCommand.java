package tcc.bank.transaction.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.math.BigDecimal;

public class CreateTransactionCommand {

    @TargetAggregateIdentifier
    private Integer id;

    private Integer type;

    private BigDecimal value;

    private Integer accountId;

    public CreateTransactionCommand(Integer id, Integer type, BigDecimal value, Integer accountId) {
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
