package org.zhuonima.exchange.accounts.requests;

import lombok.Data;
import org.zhuonima.exchange.common.models.Currency;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
public class FreezeRequest {
    private Long userId;
    private Currency currency;

    @Positive
    private BigDecimal amount;
}
