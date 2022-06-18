package com.devtiago.logisticsystem.domain;

import com.devtiago.logisticsystem.enums.ClientType;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
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
    @Min(10)
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> address;
    @Email(message = "Email should be valid")
    private String email;
    private String contact;
    @Max(25)
    @NotNull
    private String nib;
    @Enumerated(EnumType.STRING)
    private ClientType clientType;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.OrderId.class)
    private List<Order> orders;

}
