package com.devtiago.logisticsystem.domain;

import com.devtiago.logisticsystem.enums.DeliveryStatus;

import java.time.ZonedDateTime;
import java.util.ArrayList;


public class Shipment {

    private Long id;
    private Supplier supplier;
    private ArrayList<Product> products;
    private ZonedDateTime previsionDate;
    private ZonedDateTime shipmentDate;
    private DeliveryStatus shipmentStatus;
}
