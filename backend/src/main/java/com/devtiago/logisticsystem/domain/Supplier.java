package com.devtiago.logisticsystem.domain;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "t_supplier")
public class Supplier {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    private String email;
    private String contact;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
