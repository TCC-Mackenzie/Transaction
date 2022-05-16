package tcc.bank.transaction.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tcc.bank.transaction.command.CreateTransactionCommand;
import tcc.bank.transaction.command.UpdateTransactionCommand;
import tcc.bank.transaction.dto.TransactionDTO;
import tcc.bank.transaction.service.core.TransactionService;
import tcc.bank.transaction.service.model.TransactionModel;
import tcc.bank.transaction.service.model.enums.TransactionType;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

@RestController
public class TransactionController {
    private final TransactionService transactionService;
    private CommandGateway commandGateway;

    @Autowired
    public TransactionController(TransactionService transactionService, CommandGateway commandGateway) {
        this.transactionService = transactionService;
        this.commandGateway = commandGateway;
    }

    @PostMapping(value = "/v1.0")
    public CompletableFuture<String> create(@RequestBody TransactionDTO transactionDTO) {
        var transaction = new TransactionModel();
        transaction.setDate(Date.from(Instant.now()));
        transaction.setType(TransactionType.DEPOSITY);
        transaction.setValue(transactionDTO.getValue());
        transaction.setAccountId(transactionDTO.getAccountId());
        var response = transactionService.create(transaction);
        var command = new CreateTransactionCommand(response.getId(), transactionDTO.getType(), transactionDTO.getValue(), transactionDTO.getAccountId());
        return commandGateway.send(command);
    }

    @PutMapping(value = "/v1.0/{id}/reversal")
    public CompletableFuture<String> reversal(@PathVariable Integer id) {
        var command = new UpdateTransactionCommand(id, 4);
        return commandGateway.send(command);
    }
}
