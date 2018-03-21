package org.zhuonima.exchange.orders.messages;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface ExchangeOrderMessageSource {

    @Output("ORDER_OUTPUT")
    MessageChannel orderOutput();
}
