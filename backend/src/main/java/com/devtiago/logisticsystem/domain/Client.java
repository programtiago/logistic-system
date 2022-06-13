package com.devtiago.logisticsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    private Long id;
    private String name;
    private Address address;
    private String email;
    private String contact;
    private String nib;

}
