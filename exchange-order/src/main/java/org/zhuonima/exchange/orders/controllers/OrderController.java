package org.zhuonima.exchange.orders.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.zhuonima.exchange.common.domain.ApiResult;
import org.zhuonima.exchange.orders.exceptions.ExchangeOrderException;
import org.zhuonima.exchange.orders.models.Order;
import org.zhuonima.exchange.orders.requests.CancelOrderRequest;
import org.zhuonima.exchange.orders.requests.CreateOrderRequest;
import org.zhuonima.exchange.orders.services.OrderService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Mono<ApiResult> createOrder(@RequestBody CreateOrderRequest createOrder) {
        Order order = new Order();
        BeanUtils.copyProperties(createOrder, order);
        return orderService.createOrder(order)
                .map(ApiResult::success)
                .doOnError(ExchangeOrderException.class, ApiResult::failure)
                .log();
    }

    @PutMapping("/{id}")
    public Mono<ApiResult> cancelOrder(@PathVariable("id") Long id, @RequestBody CancelOrderRequest cancelOrder) {
        Order order = new Order();
        BeanUtils.copyProperties(cancelOrder, order);
        return orderService.cancelOrder(id)
                .map(ApiResult::success)
                .doOnError(ExchangeOrderException.class, ApiResult::failure)
                .log();
    }

}
