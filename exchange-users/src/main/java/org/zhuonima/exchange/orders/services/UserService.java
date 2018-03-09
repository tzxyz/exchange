package org.zhuonima.exchange.orders.services;

import org.springframework.stereotype.Service;
import org.zhuonima.exchange.orders.models.User;
import org.zhuonima.exchange.orders.repositories.UserRepository;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userReactiveRepository) {
        this.userRepository = userReactiveRepository;
    }

    public Mono<User> register(User user) {
        return Mono.just(this.userRepository.save(user));
    }
}
