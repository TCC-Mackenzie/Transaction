package tcc.bank.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcc.bank.transaction.service.model.TransactionModel;
import tcc.bank.transaction.service.repository.TransactionRepository;

@RestController
public class TransactionController {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping(value = "/v1.0")
    public ResponseEntity<Iterable<TransactionModel>> getAll() {
        return ResponseEntity.ok(transactionRepository.findAll());
    }

}
