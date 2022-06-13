package com.devtiago.logisticsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Occurrence {

    private Long id;
    private String description;
    private ZonedDateTime occurrenceDate;
}
