package com.example.transactionservice.Service;

import com.example.transactionservice.Entity.TransactionEntity;
import com.example.transactionservice.Entity.TransactionType;
import com.example.transactionservice.Repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    public TransactionRepo repo;

    public TransactionEntity deposit(String accountNo, BigDecimal amount)
    {
        TransactionEntity depo=new TransactionEntity();
        depo.setAccountNo(accountNo);
        depo.setAmount(amount);
        depo.setType(TransactionType.DEPOSIT);
        depo.setCreatedAt(LocalDateTime.now());
        return  repo.save(depo);
    }

    public TransactionEntity withdraw(String accountNo, BigDecimal amount)
    {
        TransactionEntity withdraw=new TransactionEntity();
        withdraw.setAccountNo(accountNo);
        withdraw.setAmount(amount);
       withdraw.setType(TransactionType.WITHDRAWAL);
        withdraw.setCreatedAt(LocalDateTime.now());
        return  repo.save(withdraw);
    }

    public List<TransactionEntity> getHistory(String accountNo)
    {
         return repo.findByAccountNo(accountNo);
    }
}
