package org.zhuonima.exchange.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class ApiResult<T> {
    public boolean ok;
    public Optional<String> error;
    public Optional<T> data;

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(Boolean.TRUE, Optional.empty(), Optional.of(data));
    }

    public static <T> ApiResult<T> failure(String error) {
        return new ApiResult<>(Boolean.FALSE, Optional.of(error), Optional.empty());
    }

}

