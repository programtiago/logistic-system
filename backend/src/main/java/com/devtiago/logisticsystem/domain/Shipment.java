package com.devtiago.logisticsystem.domain;

import com.devtiago.logisticsystem.enums.DeliveryStatus;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "t_shipment")
public class Shipment {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "shipment")
    private List<Product> products;
    private ZonedDateTime previsionDate;
    private ZonedDateTime shipmentDate;
    private DeliveryStatus shipmentStatus;
}
