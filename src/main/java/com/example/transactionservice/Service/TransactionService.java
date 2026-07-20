package com.example.transactionservice.Service;

import com.example.transactionservice.Client.AccountClient;
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

    @Autowired
    private AccountClient accountClient;

    public TransactionEntity deposit(String accountNo, BigDecimal amount) {
        TransactionEntity depo = new TransactionEntity();
        depo.setAccountNo(accountNo);
        depo.setAmount(amount);
        depo.setType(TransactionType.DEPOSIT);
        depo.setCreatedAt(LocalDateTime.now());
        TransactionEntity saved = repo.save(depo);

        accountClient.updateBalance(accountNo, amount, "DEPOSIT");

        return saved;
    }

    public TransactionEntity withdraw(String accountNo, BigDecimal amount)
    {
        TransactionEntity withdraw=new TransactionEntity();
        withdraw.setAccountNo(accountNo);
        withdraw.setAmount(amount);
       withdraw.setType(TransactionType.WITHDRAWAL);
        withdraw.setCreatedAt(LocalDateTime.now());
        TransactionEntity saved=repo.save(withdraw);
        accountClient.updateBalance(accountNo,amount,"WITHDRAWAL");

        return saved;
    }

    public List<TransactionEntity> getHistory(String accountNo)
    {
         return repo.findByAccountNo(accountNo);
    }


}
