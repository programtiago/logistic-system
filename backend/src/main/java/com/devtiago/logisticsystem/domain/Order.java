package com.devtiago.logisticsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

    private Long id;
    private ZonedDateTime creationOrder;
    private ZonedDateTime previsionOrderDelivery;
    private Client client;
    private ArrayList<Product> products;


}
