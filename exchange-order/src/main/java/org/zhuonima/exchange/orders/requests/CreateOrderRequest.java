package org.zhuonima.exchange.orders.requests;

import lombok.Data;
import org.zhuonima.exchange.common.models.Symbol;
import org.zhuonima.exchange.orders.models.OrderType;

import java.math.BigDecimal;

@Data
public class CreateOrderRequest {
    private Long userId;
    private Symbol symbol;
    private OrderType type;
    private BigDecimal price;
    private BigDecimal amount;
}
