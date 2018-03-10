package org.zhuonima.exchange.accounts.exceptions;

import org.zhuonima.exchange.common.exceptions.ExchangeException;

public class ExchangeAccountException extends ExchangeException {

    private final static String SERVICE = "exchange-account";

    public ExchangeAccountException(String message) {
        super(message, SERVICE);
    }

    public ExchangeAccountException(String message, Throwable cause) {
        super(message, SERVICE, cause);
    }
}
