package org.zhuonima.exchange.common.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize(using = ExchangeExceptionSerialzer.class)
public class ExchangeException extends RuntimeException {

    private long timestamp;

    private String service;

    private Throwable cause;

    private ObjectMapper mapper = new ObjectMapper();

    public ExchangeException(String message, String service) {
        super(message);
        this.service = service;
        this.timestamp = System.currentTimeMillis();
    }

    public ExchangeException(String message, String service, Throwable cause) {
        super(message, cause);
        this.service = service;
        this.timestamp = System.currentTimeMillis();
    }
}
