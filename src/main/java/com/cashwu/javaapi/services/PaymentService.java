package com.cashwu.javaapi.services;

import com.cashwu.javaapi.exceptions.NotEnoughMoneyException;
import com.cashwu.javaapi.model.PaymentDetails;
import org.springframework.stereotype.Service;

/**
 * @author cash.wu
 * @since 2024/05/08
 */
@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
