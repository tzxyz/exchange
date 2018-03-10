package org.zhuonima.exchange.orders.requests;

import lombok.Data;
import org.zhuonima.exchange.common.models.Currency;

import java.math.BigDecimal;

@Data
public class DepositRequest {
    private Long userId;
    private Currency currency;
    private BigDecimal balance;
}
