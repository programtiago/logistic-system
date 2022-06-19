package com.devtiago.logisticsystem.domain;

import com.devtiago.logisticsystem.enums.CategoryStatus;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "t_category")
public class Category {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ZonedDateTime categoryCreated;
    private String description;
    @Enumerated(EnumType.STRING)
    private CategoryStatus categoryStatus = CategoryStatus.ENABLED;
}
