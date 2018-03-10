package org.zhuonima.exchange.orders.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.zhuonima.exchange.orders.services.AccountService;

@RestController
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

}
