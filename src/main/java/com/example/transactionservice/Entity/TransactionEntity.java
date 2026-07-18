package com.example.transactionservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name ="transaction")
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

   private  String accountNo;
    private LocalDateTime createdAt;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

}
