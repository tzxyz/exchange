package org.zhuonima.exchange.common.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import org.zhuonima.exchange.common.domain.ApiResult;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ExchangeExceptionHandler implements WebExceptionHandler {


    private DefaultErrorWebExceptionHandler defaultErrorWebExceptionHandler;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {

        ServerHttpResponse response = exchange.getResponse();

        if (ex instanceof ExchangeException) {
            try {

                byte[] data = mapper.writeValueAsBytes(ApiResult.failure((ExchangeException) ex));
                DataBuffer dataBuffer = response.bufferFactory().wrap(data);
                response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                response.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
                return response.writeWith(Flux.just(dataBuffer));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return unhandleException(response, ex);
            }
        } else {
            return unhandleException(response, ex);
        }
    }

    private Mono<Void> unhandleException(ServerHttpResponse response, Throwable ex) {
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
        return response.setComplete();
    }
}
