package com.cashwu.javaapi.proxy;

import com.cashwu.javaapi.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * @author cash.wu
 * @since 2024/05/08
 */
@Component
public class PaymentProxyRestTemplate {

    private final RestTemplate restTemplate;

    @Value("${name.service.url}")
    private String paymentServiceUrl;

    public PaymentProxyRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment createPayment(Payment payment) {

        String uri = paymentServiceUrl + "/payment";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("requestId",
                        UUID.randomUUID()
                            .toString());

        var httpEntity = new HttpEntity(payment, httpHeaders);

        //        restTemplate.postForObject(uri, httpEntity, Payment.class);

        ResponseEntity<Payment> response = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, Payment.class);

        return response.getBody();
    }

}
