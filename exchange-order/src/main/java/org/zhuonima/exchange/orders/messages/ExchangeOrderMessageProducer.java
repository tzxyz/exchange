package org.zhuonima.exchange.orders.messages;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class ExchangeOrderMessageProducer implements CommandLineRunner {

    private final Source source;


    public ExchangeOrderMessageProducer(Source source) {
        this.source = source;
    }

    public void send(String s) {
//        source.output().send(MessageBuilder.withPayload(s).build());
        source.output().send(MessageBuilder.withPayload(s).build());
    }

    /**
     * todo 在启动时，把所有SUBMMITED状态的Order发送到队列中
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
//        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> {
//            for (int i = 0; i < 30; i++) {
//                send("ssss" + String.valueOf(System.currentTimeMillis()));
//            }
//        }, 0, 1, TimeUnit.SECONDS);
    }
}
