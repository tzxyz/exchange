package org.zhuonima.exchange.sequence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class ExchangeSequenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeSequenceApplication.class, args);
	}
}
