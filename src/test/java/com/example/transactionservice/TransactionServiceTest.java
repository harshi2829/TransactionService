    package com.example.transactionservice;

    import com.example.transactionservice.Client.AccountClient;
    import com.example.transactionservice.Entity.TransactionEntity;
    import com.example.transactionservice.Repository.TransactionRepo;
    import com.example.transactionservice.Service.TransactionService;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.extension.ExtendWith;
    import org.mockito.InjectMocks;
    import org.mockito.Mock;
    import org.mockito.junit.jupiter.MockitoExtension;

    import java.math.BigDecimal;
    import java.util.Optional;
    import java.util.List; // ✅
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertNotNull;
    import static org.mockito.ArgumentMatchers.any;
    import static org.mockito.Mockito.verify;
    import static org.mockito.Mockito.when;

    @ExtendWith(MockitoExtension.class)
    public class TransactionServiceTest {

        @Mock
        TransactionRepo repo;

        @Mock
        AccountClient accountClient;

        @InjectMocks
        TransactionService service;

        TransactionEntity account;

        @BeforeEach
        void setUp()
        {
            account=new TransactionEntity();
            account.setAccountNo("ACC123");
            account.setAmount(new BigDecimal("500"));
            account.setId(1L);
        }

        @Test
        void getDeposit()
        {
            when(repo.save(any(TransactionEntity.class))).thenReturn(account);

            TransactionEntity result=service.deposit("ACC123",new BigDecimal("500"));

            assertNotNull(result);
            assertEquals("ACC123",result.getAccountNo());
            verify(accountClient).updateBalance("ACC123", new BigDecimal("500"), "DEPOSIT");
        }


        @Test
        void getWithdraw()
        {
            when(repo.save(any(TransactionEntity.class))).thenReturn(account);

            TransactionEntity result=service.withdraw("ACC123",new BigDecimal("500"));

            assertNotNull(result);
            assertEquals("ACC123",result.getAccountNo());
            verify(accountClient).updateBalance("ACC123", new BigDecimal("500"), "WITHDRAWAL");
        }


        @Test
        void getHistory()
        {
            when(repo.findByAccountNo("ACC123")).thenReturn(List.of(account));

            List<TransactionEntity> result=service.getHistory("ACC123");

            assertNotNull(result);
            assertEquals(1,result.size());



        }
        }

