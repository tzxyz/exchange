package org.zhuonima.exchange.euraka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ExchangeEurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExchangeEurekaServerApplication.class, args);
	}
}
