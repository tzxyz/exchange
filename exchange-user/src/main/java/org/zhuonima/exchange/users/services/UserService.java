package org.zhuonima.exchange.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhuonima.exchange.users.exceptions.ExchangeUserException;
import org.zhuonima.exchange.users.models.User;
import org.zhuonima.exchange.users.repositories.UserRepository;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> register(User user) throws ExchangeUserException {
        checkEmail(user);
        return Mono.just(this.userRepository.save(user));
    }

    public Mono<User> login(User user) throws ExchangeUserException {
        return Mono.just(this.userRepository.findFirstByEmail(user.getEmail()));
    }

    private void checkEmail(User user) {
        User u = userRepository.findFirstByEmail(user.getEmail());
        if (u != null) {
            throw new ExchangeUserException("该邮箱已经注册");
        }
    }

}
