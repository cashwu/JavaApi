package com.cashwu.javaapi;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author cash.wu
 */
@Configuration
@EnableFeignClients(basePackages = "com.cashwu.javaapi")
public class ProjectConfig {

    @Bean
    RestTemplate restTemplate (){
        return new RestTemplate();
    }

    @Bean
    WebClient webClient(){
        return WebClient.builder().build();
    }
}