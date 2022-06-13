package com.devtiago.logisticsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Supplier {

    private Long id;
    private String description;
    private Address address;
    private String email;
    private String contact;
}
