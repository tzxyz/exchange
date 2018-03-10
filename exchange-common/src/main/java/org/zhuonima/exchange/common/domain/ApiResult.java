package org.zhuonima.exchange.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.zhuonima.exchange.common.exceptions.ExchangeException;

@Data
@AllArgsConstructor
public class ApiResult {
    public boolean ok;
    public ExchangeException error;
    public Object data;

    public static ApiResult success(Object data) {
        return new ApiResult(Boolean.TRUE, null, data);
    }

    public static ApiResult failure(ExchangeException e) {
        return new ApiResult(Boolean.FALSE, e, null);
    }


}

