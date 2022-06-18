package com.devtiago.logisticsystem.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "t_product")
public class Product {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String description;
    @NotNull
    private String clientCode;
    private int quantity;
    private double weight;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Supplier> suppliers;
    @ManyToOne
    private Shipment shipment;

}
