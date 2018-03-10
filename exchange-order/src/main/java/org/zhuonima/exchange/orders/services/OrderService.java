package org.zhuonima.exchange.orders.services;

import org.springframework.stereotype.Service;
import org.zhuonima.exchange.orders.exceptions.ExchangeOrderException;
import org.zhuonima.exchange.orders.models.Order;
import org.zhuonima.exchange.orders.models.OrderStatus;
import org.zhuonima.exchange.orders.repositories.OrderRepository;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Mono<Order> createOrder(Order order) throws ExchangeOrderException {

        // TODO 处理冻结账户相关
        switch (order.getType()) {
            case BUY_LIMIT:
                // 冻结账户
            case SELL_LIMIT:
                // 冻结账户
            case BUY_MARKET:
                throw new UnsupportedOperationException();
            case SELL_MARKET:
                throw new UnsupportedOperationException();
        }

        order.setStatus(OrderStatus.SUBMITTED);

        // TODO 进入消息队列
        return Mono.just(orderRepository.save(order));
    }

    public Mono<Order> cancelOrder(Long id) throws ExchangeOrderException  {
        Optional<Order> optional = orderRepository.findById(id);

        if (!optional.isPresent()) throw new ExchangeOrderException("订单不存在");

        // 进入消息队列
        return Mono.empty();
    }

}
