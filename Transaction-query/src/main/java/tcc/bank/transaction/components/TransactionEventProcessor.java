package tcc.bank.transaction.components;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import tcc.bank.transaction.event.CreateTransactionEvent;
import tcc.bank.transaction.service.model.TransactionModel;
import tcc.bank.transaction.service.repository.TransactionRepository;

import java.time.Instant;
import java.util.Date;

@Component
@ProcessingGroup("amqpEvents")
public class TransactionEventProcessor {

    private final TransactionRepository transactionRepository;

    public TransactionEventProcessor(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @EventHandler
    public void on(CreateTransactionEvent event) {
        transactionRepository.save(new TransactionModel(event.getId(), Date.from(Instant.now()), event.getType(), event.getValue(), event.getAccountId()));
    }
}
