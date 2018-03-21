package org.zhuonima.exchange.orders.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhuonima.exchange.orders.calls.AccountInterface;
import org.zhuonima.exchange.orders.exceptions.ExchangeOrderException;
import org.zhuonima.exchange.orders.models.Order;
import org.zhuonima.exchange.orders.models.OrderStatus;
import org.zhuonima.exchange.orders.repositories.OrderRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class OrderService {

    private final AccountInterface accountInterface;

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(AccountInterface accountInterface, OrderRepository orderRepository) {
        this.accountInterface = accountInterface;
        this.orderRepository = orderRepository;
    }

    public Mono<Order> createOrder(Order order) throws ExchangeOrderException {

        // TODO 处理冻结账户相关
        switch (order.getType()) {
            case BUY_LIMIT:
                // 冻结账户
                break;
            case SELL_LIMIT:
                // 冻结账户
                break;
            case BUY_MARKET:
                throw new UnsupportedOperationException();
            case SELL_MARKET:
                throw new UnsupportedOperationException();
        }

        order.setStatus(OrderStatus.SUBMITTED);

        // TODO 进入消息队列
        return Mono.just(orderRepository.save(order));
    }

    public Mono<Order> cancelOrder(Long id) throws ExchangeOrderException {
        Optional<Order> optional = orderRepository.findById(id);

        if (!optional.isPresent()) throw new ExchangeOrderException("订单不存在");

        // 进入消息队列
        return Mono.empty();
    }

    // TODO
    public Flux<Order> findAll() throws ExchangeOrderException {
        return Flux.empty();
    }

}
