package org.zhuonima.exchange.accounts.requests;

import lombok.Data;
import org.zhuonima.exchange.common.models.Currency;

import java.math.BigDecimal;

@Data
public class UnfreezeRequest {
    private Long userId;
    private Currency currency;
    private BigDecimal amount;
}
