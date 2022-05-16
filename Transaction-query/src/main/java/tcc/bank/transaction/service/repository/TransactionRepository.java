package tcc.bank.transaction.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tcc.bank.transaction.service.model.TransactionModel;

@Repository
public interface TransactionRepository extends MongoRepository<TransactionModel, Integer> {
}
