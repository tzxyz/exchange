package org.zhuonima.exchange.orders.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.zhuonima.exchange.common.domain.ApiResult;
import org.zhuonima.exchange.orders.models.User;
import org.zhuonima.exchange.orders.services.UserService;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public Mono<ApiResult<User>> register(User user) {
        return userService.register(user).log().map(ApiResult::success);
    }


}
