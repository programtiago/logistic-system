package com.devtiago.logisticsystem.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "t_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String clientCode;
    private int quantity;
    private double weight;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Supplier> suppliers;
    @ManyToOne
    private Shipment shipment;

}
