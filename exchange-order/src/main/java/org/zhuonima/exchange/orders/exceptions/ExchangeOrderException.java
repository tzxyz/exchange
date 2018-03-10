package org.zhuonima.exchange.orders.exceptions;

import org.zhuonima.exchange.common.exceptions.ExchangeException;

public class ExchangeOrderException extends ExchangeException {

    private static final String SERVICE = "exchange-order";

    public ExchangeOrderException(String message) {
        super(message, SERVICE);
    }

    public ExchangeOrderException(String message, Throwable cause) {
        super(message, SERVICE, cause);
    }
}
