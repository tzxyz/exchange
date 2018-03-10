package org.zhuonima.exchange.users.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhuonima.exchange.common.domain.ApiResult;
import org.zhuonima.exchange.users.exceptions.ExchangeUserException;
import org.zhuonima.exchange.users.models.User;
import org.zhuonima.exchange.users.requests.LoginRequest;
import org.zhuonima.exchange.users.requests.RegisterRequest;
import org.zhuonima.exchange.users.services.UserService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Mono<ApiResult> register(@RequestBody RegisterRequest register) {
        User user = new User();
        BeanUtils.copyProperties(register, user);
        return userService.register(user).log().map(ApiResult::success).doOnError(ExchangeUserException.class, ApiResult::failure);
    }

    @PostMapping("/login")
    public Mono<ApiResult> login(@RequestBody LoginRequest login) {
        User user = new User();
        BeanUtils.copyProperties(login, user);
        return userService.login(user).log().map(ApiResult::success).doOnError(ExchangeUserException.class, ApiResult::failure);
    }

}
