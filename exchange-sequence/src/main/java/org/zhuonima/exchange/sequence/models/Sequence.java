package org.zhuonima.exchange.sequence.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exchange_sequence", indexes = @Index(columnList = "sequenceNumber", unique = true))
public class Sequence {

    ///// todo 定序能否使用db
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long orderId;

    private Long sequenceNumber;

    @CreatedDate
    private Long created;
}
