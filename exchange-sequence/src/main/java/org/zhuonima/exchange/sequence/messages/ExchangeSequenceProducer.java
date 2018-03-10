package org.zhuonima.exchange.sequence.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ExchangeSequenceProducer implements CommandLineRunner {

    private final Queue queue;

    private final JmsMessagingTemplate jmsMessagingTemplate;

    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    @Autowired
    public ExchangeSequenceProducer(Queue queue, JmsMessagingTemplate jmsMessagingTemplate) {
        this.queue = queue;
        this.jmsMessagingTemplate = jmsMessagingTemplate;
//        this.jmsMessagingTemplate.setDefaultDestinationName("sample.queue");
    }

    public void send(String message) {
        jmsMessagingTemplate.convertAndSend(queue, message);
    }

    @Override
    public void run(String... args) throws Exception {
        executor.scheduleAtFixedRate(() -> {
            send("666");
        }, 0, 1, TimeUnit.MICROSECONDS);
    }
}
