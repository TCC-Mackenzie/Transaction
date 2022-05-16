package tcc.bank.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tcc.bank.transaction.dto.TransactionDTO;
import tcc.bank.transaction.service.core.TransactionService;
import tcc.bank.transaction.service.model.TransactionModel;
import tcc.bank.transaction.service.model.enums.TransactionType;

import java.time.Instant;
import java.util.Date;

@RestController
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(value = "/v1.0/deposity")
    public ResponseEntity desposity(@RequestBody TransactionDTO transactionDTO) {
        var transaction = new TransactionModel();
        transaction.setDate(Date.from(Instant.now()));
        transaction.setType(TransactionType.DEPOSITY);
        transaction.setValue(transactionDTO.getValue());
        transaction.setAccountId(transactionDTO.getAccountId());
        transactionService.create(transaction);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/v1.0/pix")
    public ResponseEntity pix(@RequestBody TransactionDTO transactionDTO) {
        var transaction = new TransactionModel();
        transaction.setDate(Date.from(Instant.now()));
        transaction.setType(TransactionType.PIX);
        transaction.setValue(transactionDTO.getValue());
        transaction.setAccountId(transactionDTO.getAccountId());
        transactionService.create(transaction);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/v1.0/ted")
    public ResponseEntity ted(@RequestBody TransactionDTO transactionDTO) {
        var transaction = new TransactionModel();
        transaction.setDate(Date.from(Instant.now()));
        transaction.setType(TransactionType.TED);
        transaction.setValue(transactionDTO.getValue());
        transaction.setAccountId(transactionDTO.getAccountId());
        transactionService.create(transaction);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/v1.0/doc")
    public ResponseEntity doc(@RequestBody TransactionDTO transactionDTO) {
        var transaction = new TransactionModel();
        transaction.setDate(Date.from(Instant.now()));
        transaction.setType(TransactionType.DOC);
        transaction.setValue(transactionDTO.getValue());
        transaction.setAccountId(transactionDTO.getAccountId());
        transactionService.create(transaction);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/v1.0/reversal")
    public ResponseEntity reversal(@RequestBody TransactionDTO transactionDTO) {
        var transaction = new TransactionModel();
        transaction.setDate(Date.from(Instant.now()));
        transaction.setType(TransactionType.REVERSAL);
        transaction.setValue(transactionDTO.getValue());
        transaction.setAccountId(transactionDTO.getAccountId());
        transactionService.create(transaction);
        return new ResponseEntity(HttpStatus.OK);
    }
}
