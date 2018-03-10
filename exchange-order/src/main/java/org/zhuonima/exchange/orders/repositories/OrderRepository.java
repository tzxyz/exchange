package org.zhuonima.exchange.orders.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.zhuonima.exchange.orders.models.Order;

public interface OrderRepository extends PagingAndSortingRepository<Long, Order> {
}
