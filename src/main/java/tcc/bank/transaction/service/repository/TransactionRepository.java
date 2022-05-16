package tcc.bank.transaction.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcc.bank.transaction.service.model.TransactionModel;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Integer> {
}
