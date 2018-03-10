package org.zhuonima.exchange.users.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.zhuonima.exchange.users.models.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findFirstByEmail(String email);
}