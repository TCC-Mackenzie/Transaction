package tcc.bank.transaction.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.bank.transaction.service.model.TransactionModel;
import tcc.bank.transaction.service.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionModel create(TransactionModel transactionModel) {
        return transactionRepository.save(transactionModel);
    }
}
