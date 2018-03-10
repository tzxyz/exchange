package org.zhuonima.exchange.orders.services;

import org.springframework.stereotype.Service;
import org.zhuonima.exchange.orders.models.Account;
import org.zhuonima.exchange.orders.repositories.AccountRepository;
import org.zhuonima.exchange.orders.requests.DepositRequest;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Mono<Account> deposit(DepositRequest depositRequest) {
        // 存在账号添加

        // 不存在创建
        return Mono.empty();
    }
}
