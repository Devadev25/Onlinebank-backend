package com.banking.banking.controller;

import com.banking.banking.entity.Transaction;
import com.banking.banking.service.implementation.BankStatementService;
import com.itextpdf.text.DocumentException;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/bankStatement")
@AllArgsConstructor
@CrossOrigin("*")
public class TransactionalController {
    @Autowired
    private BankStatementService bankStatementService;

    @GetMapping("/pdf")
    public List<Transaction> generateBankStatement(@RequestParam String accountNumber,@RequestParam String startDate,@RequestParam String endDate) throws DocumentException, FileNotFoundException, MessagingException {
        return bankStatementService.generateStatement(accountNumber, startDate, endDate);
    }
    @GetMapping("/history")
    public List<Transaction> getTransactionsByDateRange(@RequestParam String accountNumber,@RequestParam String startDate,@RequestParam String endDate) throws Exception {
        return bankStatementService.getTransactionsByDateRange(accountNumber, startDate, endDate);
    }

    @GetMapping("/total-amount")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<BigDecimal> getTotalTransactionsAmount() {
        BigDecimal transaction=bankStatementService.getTotalTransactions();
        return ResponseEntity.ok(transaction);
    }

}
