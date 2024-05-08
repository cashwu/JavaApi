package com.cashwu.javaapi;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author cash.wu
 * @since 2024/05/08
 */
@Configuration
@EnableFeignClients(basePackages = "com.cashwu.javaapi")
public class ProjectConfig {

}
