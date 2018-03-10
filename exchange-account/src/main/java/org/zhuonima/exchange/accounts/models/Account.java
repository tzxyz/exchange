package org.zhuonima.exchange.accounts.models;

import lombok.Data;
import org.zhuonima.exchange.common.models.Currency;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(
    name = "exchange_accounts",
    uniqueConstraints = @UniqueConstraint(columnNames = {"userId", "currency"})
)
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private BigDecimal balance;

    private BigDecimal frozen;
}
