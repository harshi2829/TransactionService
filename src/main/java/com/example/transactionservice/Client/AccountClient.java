package com.example.transactionservice.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountClient {
    @PutMapping("/account/update-balance")
    void updateBalance(@RequestParam String accountNo,
                       @RequestParam BigDecimal amount,
                       @RequestParam String operation);
}
