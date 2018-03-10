package org.zhuonima.exchange.orders.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.zhuonima.exchange.orders.services.OrderService;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
}
