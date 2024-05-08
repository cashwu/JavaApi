package com.cashwu.javaapi.controller;

import com.cashwu.javaapi.exceptions.ErrorDetails;
import com.cashwu.javaapi.exceptions.NotEnoughMoneyException;
import com.cashwu.javaapi.model.PaymentDetails;
import com.cashwu.javaapi.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cash.wu
 * @since 2024/05/08
 */
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(@RequestBody PaymentDetails paymentDetails) {

//        PaymentDetails paymentDetails = paymentService.processPayment();

//        return ResponseEntity.status(HttpStatus.ACCEPTED)
//                             .body(paymentDetails);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                             .body(paymentDetails);

    }
}

