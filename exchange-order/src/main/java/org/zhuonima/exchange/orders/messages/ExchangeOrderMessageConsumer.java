package org.zhuonima.exchange.orders.messages;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({Sink.class})
public class ExchangeOrderMessageConsumer implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public ExchangeOrderMessageConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @StreamListener(Sink.INPUT)
    public void onMessage(String message) {
        System.out.println("@StreamListener : " + message);
    }

    @Override
    public void run(String... args) throws Exception {
//        Object message = rabbitTemplate.receiveAndConvert("666");
//        System.out.println(message.toString());

//        rabbitTemplate.send();
    }
}
