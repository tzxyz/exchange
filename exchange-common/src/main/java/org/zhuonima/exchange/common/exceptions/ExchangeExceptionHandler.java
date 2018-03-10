package org.zhuonima.exchange.common.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import org.zhuonima.exchange.common.domain.ApiResult;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ExchangeExceptionHandler implements WebExceptionHandler {


    private DefaultErrorWebExceptionHandler defaultErrorWebExceptionHandler;
    private ObjectMapper mapper = new ObjectMapper();

    //
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {

        if (ex instanceof ExchangeException) {
            try {

                byte[] data = mapper.writeValueAsBytes(ApiResult.failure((ExchangeException) ex));
                ServerHttpResponse response = exchange.getResponse();
                DataBuffer dataBuffer = response.bufferFactory().wrap(data);
                response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);

//                ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .syncBody(ex)
//                        .log().flatMap((ServerResponse s) -> s.writeTo(exchange, AbstractErrorWebExceptionHandler.ResponseContext));


                return response.writeWith(Flux.just(dataBuffer));
            } catch (Exception e) {
                return Mono.empty();
            }
        } else {
            return defaultErrorWebExceptionHandler.handle(exchange, ex);
        }
    }
}
