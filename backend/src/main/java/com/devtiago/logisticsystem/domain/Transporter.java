package com.devtiago.logisticsystem.domain;

import com.devtiago.logisticsystem.enums.MeansTransport;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "t_transporter")
public class Transporter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registration;
    private String driverName;
    private MeansTransport transportType;
    private ZonedDateTime transportArrived;
    private ZonedDateTime transportDeparture;
    private String contact;
    private String email;
    private int pallets;

}
