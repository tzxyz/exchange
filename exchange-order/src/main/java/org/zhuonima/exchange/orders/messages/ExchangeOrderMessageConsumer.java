package org.zhuonima.exchange.orders.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
@EnableBinding(Source.class)
public class ExchangeOrderMessageProducer {

    private final Source source;

    public ExchangeOrderMessageProducer(Source source) {
        this.source = source;
    }

    public void send(String s) {
        source.output().send(MessageBuilder.withPayload(s).build());
    }

    @PostConstruct
    public void start() {
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> {
            send("ssss");
        }, 0, 1, TimeUnit.SECONDS);
    }
}
