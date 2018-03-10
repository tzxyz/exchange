package org.zhuonima.exchange.orders.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.zhuonima.exchange.orders.models.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findFirstByEmail(String email);
}