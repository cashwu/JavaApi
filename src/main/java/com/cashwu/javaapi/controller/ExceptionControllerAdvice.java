package com.cashwu.javaapi.controller;

import com.cashwu.javaapi.exceptions.ErrorDetails;
import com.cashwu.javaapi.exceptions.NotEnoughMoneyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author cash.wu
 * @since 2024/05/08
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> notEnoughMoneyException() {

        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setMessage("not enough money");

        return ResponseEntity.badRequest()
                             .body(errorDetails);

    }

}
