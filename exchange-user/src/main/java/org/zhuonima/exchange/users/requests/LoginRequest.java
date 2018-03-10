package org.zhuonima.exchange.users.requests;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
