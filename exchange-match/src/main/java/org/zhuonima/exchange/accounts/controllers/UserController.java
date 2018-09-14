package org.zhuonima.exchange.accounts.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.zhuonima.exchange.common.domain.ApiResult;
import org.zhuonima.exchange.accounts.models.User;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    public Mono<ApiResult<User>> register(User user) {
        return Mono.just(ApiResult.success(user));
    }


}
