package com.devtiago.logisticsystem.domain;

import com.devtiago.logisticsystem.enums.ClientType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Client {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> address;
    @Email(message = "Email should be valid")
    private String email;
    private String contact;
    private String nib;
    @Enumerated(EnumType.STRING)
    private ClientType clientType;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> orders;

}
