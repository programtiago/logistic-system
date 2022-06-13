package com.devtiago.logisticsystem.domain;

import com.devtiago.logisticsystem.enums.MeansTransport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transporter {

    private Long id;
    private String registration;
    private String driverName;
    private MeansTransport transportType;
    private ZonedDateTime transportArrived;
    private ZonedDateTime transportDeparture;
    private String contact;
    private String email;
    private Order order;
    private int pallets;

}
