package org.zhuonima.exchange.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExchangeOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeOrderApplication.class, args);
	}
}
