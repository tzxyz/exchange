package org.zhuonima.exchange.accounts.controllers;

import org.springframework.web.bind.annotation.*;
import org.zhuonima.exchange.accounts.exceptions.ExchangeAccountException;
import org.zhuonima.exchange.accounts.requests.DepositRequest;
import org.zhuonima.exchange.accounts.requests.FreezeRequest;
import org.zhuonima.exchange.accounts.requests.UnfreezeRequest;
import org.zhuonima.exchange.accounts.services.AccountService;
import org.zhuonima.exchange.common.domain.ApiResult;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public Mono<ApiResult> listAccounts(Long userId) {
        return accountService.listAccounts(userId).collectList().map(ApiResult::success).doOnError(ExchangeAccountException.class, ApiResult::failure).log();
    }

    @PostMapping("/deposit")
    public Mono<ApiResult> deposit(@RequestBody DepositRequest deposit) {
        return accountService.deposit(deposit).map(ApiResult::success).doOnError(ExchangeAccountException.class, ApiResult::failure).log();
    }

    @PutMapping("/freeze")
    public Mono<ApiResult> freeze(@RequestBody FreezeRequest freeze) {
        return accountService.freeze(freeze).map(ApiResult::success).doOnError(ExchangeAccountException.class, ApiResult::failure).log();
    }

    @PutMapping("/unfreeze")
    public Mono<ApiResult> unfreeze(@RequestBody UnfreezeRequest unfreeze) {
        return accountService.unfreeze(unfreeze).map(ApiResult::success).doOnError(ExchangeAccountException.class, ApiResult::failure).log();
    }
}
