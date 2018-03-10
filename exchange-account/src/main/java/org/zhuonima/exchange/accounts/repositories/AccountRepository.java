package org.zhuonima.exchange.orders.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.zhuonima.exchange.orders.models.Account;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
}
