package com.cashwu.javaapi.proxy;

import com.cashwu.javaapi.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author cash.wu
 * @since 2024/05/08
 */
@FeignClient(name = "payments",
             url = "${name.service.url}")
public interface PaymentProxy {

    @PostMapping("/payment")
    Payment createPayment(@RequestHeader String requestId,
                          @RequestBody Payment payment);
}

