package com.banking.banking.service.implementation;

import com.banking.banking.dto.TransactionRequest;
import com.banking.banking.entity.User;

import java.math.BigDecimal;

public interface TransactionService {
    void saveTransaction(TransactionRequest transaction);


}
