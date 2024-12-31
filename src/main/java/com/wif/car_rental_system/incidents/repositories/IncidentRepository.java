package com.wif.car_rental_system.incidents.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wif.car_rental_system.incidents.domain.entities.IncidentEntity;

@Repository
public interface IncidentRepository extends JpaRepository<IncidentEntity, Long> {
  List<IncidentEntity> getAllByRentalId(Long rentalId);
}
