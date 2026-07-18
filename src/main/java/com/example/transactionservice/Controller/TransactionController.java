package com.example.transactionservice.Controller;

import com.example.transactionservice.Entity.TransactionEntity;
import com.example.transactionservice.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    public TransactionService service;

    @GetMapping("history/{accountNo}")
    public List<TransactionEntity> history(@PathVariable  String accountNo)
    {
        return service.getHistory(accountNo);
    }

    @PostMapping("/deposit")
    public TransactionEntity deposit(@RequestParam  String accountNo,   @RequestParam BigDecimal amount)
    {
        return service.deposit(accountNo, amount);
    }

    @PostMapping("/withdraw")
    public TransactionEntity withdrawl(@RequestParam  String accountNo,   @RequestParam BigDecimal amount)
    {
        return service.withdraw(accountNo, amount);
    }


}
