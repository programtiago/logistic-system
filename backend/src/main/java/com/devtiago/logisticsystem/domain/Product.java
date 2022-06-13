package com.devtiago.logisticsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    private Long id;
    private String description;
    private String clientCode;
    private int quantity;
    private double weight;
    private Supplier supplier;

}
