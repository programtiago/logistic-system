package com.devtiago.logisticsystem.domain;

import com.devtiago.logisticsystem.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private ZonedDateTime creationOrder;
    @NotNull
    private ZonedDateTime previsionOrderDelivery;
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    @NotNull
    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
    private Client client;
    @NotNull
    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ProductId.class)
    private ArrayList<Product> products;
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.STARTED;

    @AssertTrue(message = "Field `creationOrder` should be later than `previsionOrderDelivery`")
    private boolean isCreationOrderAfterPrevisionOrder(){
        return creationOrder.isBefore(previsionOrderDelivery);
    }

}
