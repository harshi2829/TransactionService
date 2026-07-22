package com.example.transactionservice.Controller;

import com.example.transactionservice.Entity.TransactionEntity;
import com.example.transactionservice.Service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Transaction  Controller", description = "APIs for user transaction")
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    public TransactionService service;


    @Operation(summary = "User history", description = " Fetches User account history")
    @GetMapping("history/{accountNo}")
    public List<TransactionEntity> history(@PathVariable  String accountNo)
    {
        return service.getHistory(accountNo);
    }


    @Operation(summary = "User Deposit", description = "Creates user account deposit")
    @PostMapping("/deposit")
    public TransactionEntity deposit(@RequestParam  String accountNo,   @RequestParam BigDecimal amount)
    {
        return service.deposit(accountNo, amount);
    }


    @Operation(summary = "User Withdrawl", description = "User account withdrawl")
    @PostMapping("/withdraw")
    public TransactionEntity withdrawl(@RequestParam  String accountNo,   @RequestParam BigDecimal amount)
    {
        return service.withdraw(accountNo, amount);
    }


}
