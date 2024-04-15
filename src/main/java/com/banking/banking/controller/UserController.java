package com.banking.banking.controller;

import com.banking.banking.advice.BalanceNotSufficientException;
import com.banking.banking.advice.InvalidInputException;
import com.banking.banking.dto.*;
import com.banking.banking.service.implementation.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public BankResponseDto createAccount(@Valid @RequestBody UserRequestDto user) {
        return userService.createAccount(user);
    }

    @PostMapping("user/login")
    public BankResponseDto login(@Valid @RequestBody LoginDto loginDto) throws UsernameNotFoundException, InvalidInputException {
        return userService.login(loginDto);
    }

    @PostMapping("user/balanceEnquiry")
    public BankResponseDto balanceEnquiry(@RequestBody EnquiryRequestDto enquiry) throws Exception {
        return userService.balanceEnquiry(enquiry);
    }

    @PostMapping("user/credit")
    public BankResponseDto creditAccount(@RequestBody CreditDebitRequest creditDebitRequest) throws Exception {
        return userService.creditAccount(creditDebitRequest);
    }

    @PostMapping("user/debit")
    public BankResponseDto debitAccount(@RequestBody CreditDebitRequest creditDebitRequest) throws BalanceNotSufficientException, Exception {
        return userService.debitAccount(creditDebitRequest);
    }

    @GetMapping("admin/total")
    public BankResponseDto getTotalUsers() {
        return userService.getTotalUsers();
    }


    @PostMapping("user/transfer")
    public BankResponseDto transfer(@RequestBody TransferRequest transferRequest) throws InvalidInputException, BalanceNotSufficientException {
        return userService.transfer(transferRequest);
    }
}

