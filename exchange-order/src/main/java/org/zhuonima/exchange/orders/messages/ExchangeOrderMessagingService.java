package org.zhuonima.exchange.orders.messages;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.zhuonima.exchange.orders.models.Order;

@Component
@EnableBinding(ExchangeOrderMessageSource.class)
public class ExchangeOrderMessagingService {

    private final ExchangeOrderMessageSource source;

    public ExchangeOrderMessagingService(ExchangeOrderMessageSource source) {
        this.source = source;
    }

    public void send(Order order) {
        source.orderOutput().send(MessageBuilder.withPayload(order).build());
    }
}
