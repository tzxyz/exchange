package org.zhuonima.exchange.accounts.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.zhuonima.exchange.accounts.models.Account;
import org.zhuonima.exchange.common.models.Currency;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    List<Account> findAllByUserId(Long userId);

    Optional<Account> findFirstByUserIdAndCurrency(Long userId, Currency currency);
}
