package com.devtiago.logisticsystem.repository;

import com.devtiago.logisticsystem.domain.Transporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TransporterRepository extends JpaRepository<Transporter, Long> {
}
