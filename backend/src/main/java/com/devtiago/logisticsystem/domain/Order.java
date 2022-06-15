package com.devtiago.logisticsystem.domain;

import com.devtiago.logisticsystem.enums.OrderStatus;
import lombok.*;
import org.springframework.cache.interceptor.CacheAspectSupport;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "t_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ZonedDateTime creationOrder;
    private ZonedDateTime previsionOrderDelivery;
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;
    private ArrayList<Product> products;
    private OrderStatus status;

}
