package com.banking.banking.advice;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomBankingException extends Exception{

     public CustomBankingException(String message){
         super(message);
     }

}
