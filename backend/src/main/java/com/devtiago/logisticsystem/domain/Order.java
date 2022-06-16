package com.devtiago.logisticsystem.domain;

import com.devtiago.logisticsystem.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.time.ZonedDateTime;
import java.util.ArrayList;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "t_order")
public class Order {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ZonedDateTime creationOrder;
    private ZonedDateTime previsionOrderDelivery;
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
    private Client client;
    private ArrayList<Product> products;
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.STARTED;

}
