package com.devtiago.logisticsystem.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "t_address")
public class Address {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Address cannot be null")
    @Size(min = 20, max = 200, message = "Address must be between 20 and 200 characters")
    private String address;
    @NotNull(message = "ZipCode cannot be null")
    private String zipCode;
    @NotNull(message = "Complement cannot be null")
    private String complement;
    @NotNull(message = "District cannot be null")
    private String district;
    @NotNull(message = "Country cannot be null")
    private String country;
    @ManyToOne
    private Client client;
    @OneToOne(mappedBy = "address")
    private Supplier supplier;
}
