package org.zhuonima.exchange.users.exceptions;

import org.zhuonima.exchange.common.exceptions.ExchangeException;

public class ExchangeUserException extends ExchangeException {

    private static final String SERVICE = "exchange-user";

    public ExchangeUserException(String message) {
        super(message, SERVICE);
    }

    public ExchangeUserException(String message, Throwable cause) {
        super(message, SERVICE, cause);
    }
}
