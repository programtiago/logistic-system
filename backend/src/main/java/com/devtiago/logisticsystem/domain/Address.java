package com.devtiago.logisticsystem.domain;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "t_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String zipCode;
    private String complement;
    private String district;
    private String country;
    @ManyToOne
    private Client client;
    @OneToOne(mappedBy = "address")
    private Supplier supplier;
}
