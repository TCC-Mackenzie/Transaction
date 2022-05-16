package tcc.bank.transaction.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class UpdateTransactionCommand {

    @TargetAggregateIdentifier
    private Integer id;

    private Integer type;

    public UpdateTransactionCommand(Integer id, Integer type) {
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
