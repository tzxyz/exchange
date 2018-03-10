package org.zhuonima.exchange.orders.models;

import lombok.Data;
import org.zhuonima.exchange.common.models.Symbol;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "exchange_orders")
public class Order {

    /**
     * 订单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单类型
     *
     * @see org.zhuonima.exchange.orders.models.OrderType
     */
    private OrderType type;

    private Symbol symbol;

    private BigDecimal price;

    private BigDecimal amount;

    /**
     * 订单状态
     *
     * @see org.zhuonima.exchange.orders.models.OrderStatus
     */
    private OrderStatus status;
}
