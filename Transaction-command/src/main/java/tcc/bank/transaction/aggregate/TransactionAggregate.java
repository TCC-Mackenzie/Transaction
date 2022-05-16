package tcc.bank.transaction.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;
import tcc.bank.transaction.command.CreateTransactionCommand;
import tcc.bank.transaction.command.UpdateTransactionCommand;
import tcc.bank.transaction.event.CreateTransactionEvent;
import tcc.bank.transaction.event.UpdateTransactionEvent;

import java.math.BigDecimal;
import java.util.Date;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class TransactionAggregate {

    @AggregateIdentifier
    private Integer id;

    private Date date;

    private Integer type;

    private BigDecimal value;

    private Integer accountId;

    public TransactionAggregate() { }

    @CommandHandler
    public TransactionAggregate(CreateTransactionCommand cmd) {
        Assert.hasLength(cmd.getId().toString(), "Codigo da transacao nao pode ser nulo.");
        Assert.hasLength(cmd.getType().toString(), "Tipo da transacao nao pode ser nulo.");
        Assert.hasLength(cmd.getValue().toString(), "Valor da transacao nao pode ser nulo.");
        Assert.hasLength(cmd.getAccountId().toString(), "Codigo da conta da transacao nao pode ser nulo.");
        apply(new CreateTransactionEvent(cmd.getId(), cmd.getType(), cmd.getValue(), cmd.getAccountId()));
    }

    @CommandHandler
    public TransactionAggregate(UpdateTransactionCommand cmd) {
        Assert.hasLength(cmd.getId().toString(), "Codigo da transacao nao pode ser nulo.");
        Assert.hasLength(cmd.getType().toString(), "Tipo da transacao nao pode ser nulo.");
        apply(new UpdateTransactionEvent(cmd.getId(), cmd.getType()));
    }

    @EventSourcingHandler
    public void on(CreateTransactionEvent event) {
        this.id = event.getId();
        this.type = event.getType();
        this.value = event.getValue();
        this.accountId = event.getAccountId();
    }

    @EventSourcingHandler
    public void on(UpdateTransactionEvent event) {
        this.type = event.getType();
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
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
