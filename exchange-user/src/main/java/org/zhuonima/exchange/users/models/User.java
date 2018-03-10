package org.zhuonima.exchange.orders.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exchange_users", indexes = @Index(columnList = "email", unique = true))
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String email;

    private String password;
}
