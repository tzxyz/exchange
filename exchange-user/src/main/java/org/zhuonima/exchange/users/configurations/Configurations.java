package org.zhuonima.exchange.users.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.zhuonima.exchange.common.exceptions.ExchangeExceptionHandler;

@Configuration
public class Configurations {

    @Bean
    @Order(-2)
    public ExchangeExceptionHandler exchangeExceptionHandler() {
        return new ExchangeExceptionHandler();
    }
}
