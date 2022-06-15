package com.devtiago.logisticsystem.repository;

import com.devtiago.logisticsystem.domain.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
