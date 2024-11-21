package com.wif.car_rental_system.maintenance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wif.car_rental_system.maintenance.domain.entities.MaintenanceEntity;

@Repository
public interface MaintenanceRepository extends JpaRepository<MaintenanceEntity, Long> {

}
