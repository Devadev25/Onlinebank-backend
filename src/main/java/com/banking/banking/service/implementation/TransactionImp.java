package com.banking.banking.service.implementation;

import com.banking.banking.dto.TransactionRequest;
import com.banking.banking.entity.Transaction;
import com.banking.banking.repository.TransactionalRepository;
import jakarta.transaction.InvalidTransactionException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class TransactionImp implements TransactionService{
   @Autowired
    TransactionalRepository transactionalRepository;
    @SneakyThrows
    @Override
    public void saveTransaction(TransactionRequest transaction) {
        try {

            Transaction transaction1 = Transaction.builder()
                    .transactionType(transaction.getTransactionType())
                    .toAccountNumber(transaction.getToAccount())
                    .fromAccount(transaction.getFromAccount())
                    .amount(transaction.getAmount())
                    .createdAt(transaction.getCreatedAt())
                    .user(transaction.getUser())
                    .status("SUCCESS")
                    .build();
            transactionalRepository.save(transaction1);
        }catch (DataIntegrityViolationException dataIntegrityViolationException){
            throw new InvalidTransactionException("Failed to save transaction. Invalid transaction data : "+dataIntegrityViolationException);
        }
    }

    }

