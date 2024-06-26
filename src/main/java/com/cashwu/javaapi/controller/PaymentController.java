package com.cashwu.javaapi.controller;

import com.cashwu.javaapi.model.Payment;
import com.cashwu.javaapi.model.PaymentDetails;
import com.cashwu.javaapi.proxy.PaymentProxy;
import com.cashwu.javaapi.proxy.PaymentProxyRestTemplate;
import com.cashwu.javaapi.proxy.PaymentProxyWebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author cash.wu
 * @since 2024/05/08
 */
@RestController
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
    private final PaymentProxy paymentProxy;
    private final PaymentProxyRestTemplate paymentProxyRestTemplate;
    private final PaymentProxyWebClient paymentProxyWebClient;

    public PaymentController(PaymentProxy paymentProxy,
                             PaymentProxyRestTemplate paymentProxyRestTemplate,
                             PaymentProxyWebClient paymentProxyWebClient) {
        this.paymentProxy = paymentProxy;
        this.paymentProxyRestTemplate = paymentProxyRestTemplate;
        this.paymentProxyWebClient = paymentProxyWebClient;
    }

    @PostMapping("/paymentProxy")
    public Mono<Payment> createPaymentProxy(@RequestBody Payment payment) {

        log.info("create payment proxy payment {}", payment);

        //        String requestId = UUID.randomUUID().toString();
        //        return paymentProxy.createPayment(requestId, payment);

        //        return paymentProxyRestTemplate.createPayment(payment);

        String requestId = UUID.randomUUID().toString();
        return paymentProxyWebClient.createPayment(requestId, payment);
    }

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(@RequestHeader String requestId,
                                                 @RequestBody Payment payment) {

        log.info("create payment request id {}, payment {}", requestId, payment);
        payment.setId(UUID.randomUUID()
                          .toString());

        return ResponseEntity.status(HttpStatus.OK)
                             .header("requestId", requestId)
                             .body(payment);
    }

    @PostMapping("/paymentDetail")
    public ResponseEntity<?> makePayment(@RequestBody PaymentDetails paymentDetails) {

        //        PaymentDetails paymentDetails = paymentService.processPayment();

        //        return ResponseEntity.status(HttpStatus.ACCEPTED)
        //                             .body(paymentDetails);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                             .body(paymentDetails);

    }
}

