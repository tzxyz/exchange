package org.zhuonima.exchange.accounts.services;

import org.springframework.stereotype.Service;
import org.zhuonima.exchange.accounts.exceptions.ExchangeAccountException;
import org.zhuonima.exchange.accounts.models.Account;
import org.zhuonima.exchange.accounts.repositories.AccountRepository;
import org.zhuonima.exchange.accounts.requests.DepositRequest;
import org.zhuonima.exchange.accounts.requests.FreezeRequest;
import org.zhuonima.exchange.accounts.requests.UnfreezeRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Flux<Account> listAccounts(Long userId) {
        return Flux.fromIterable(accountRepository.findAllByUserId(userId));
    }

    public Mono<Account> deposit(DepositRequest deposit) throws ExchangeAccountException {

        Optional<Account> optional = accountRepository.findFirstByUserIdAndCurrency(deposit.getUserId(), deposit.getCurrency());

        if (optional.isPresent()) {
            // 存在账号添加金额
            Account account = optional.get();
            account.setBalance(account.getBalance().add(deposit.getBalance()));
            return Mono.just(accountRepository.save(account));
        } else {
            // 不存在创建并添加金额
            Account account = new Account();
            account.setUserId(deposit.getUserId());
            account.setCurrency(deposit.getCurrency());
            account.setBalance(deposit.getBalance());
            account.setFrozen(BigDecimal.ZERO);
            return Mono.just(accountRepository.save(account));
        }
    }

    public Mono<Account> freeze(FreezeRequest freeze) throws ExchangeAccountException {
        Optional<Account> optional = accountRepository.findFirstByUserIdAndCurrency(freeze.getUserId(), freeze.getCurrency());
        if (!optional.isPresent() || optional.map(Account::getBalance).map((BigDecimal b) -> b.compareTo(freeze.getAmount()) < 0).get()) {
            throw new ExchangeAccountException("冻结失败， 余额不足或账户不存在");
        }
        Account account = optional.get();
        account.setBalance(account.getBalance().subtract(freeze.getAmount()));
        account.setFrozen(account.getFrozen().add(freeze.getAmount()));
        return Mono.just(accountRepository.save(account));
    }

    public Mono<Account> unfreeze(UnfreezeRequest unfreeze) {
        Optional<Account> optional = accountRepository.findFirstByUserIdAndCurrency(unfreeze.getUserId(), unfreeze.getCurrency());
        Account account = optional.get();
        account.setBalance(account.getBalance().add(unfreeze.getAmount()));
        account.setFrozen(account.getFrozen().subtract(unfreeze.getAmount()));
        return Mono.just(accountRepository.save(account));
    }
}
