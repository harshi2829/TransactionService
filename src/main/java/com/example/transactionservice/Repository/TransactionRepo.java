package com.example.transactionservice.Repository;

import com.example.transactionservice.Entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<TransactionEntity,Long> {
    List<TransactionEntity> findByAccountNo(String accountNo);

}
