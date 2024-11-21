package com.wif.car_rental_system.maintenance.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.wif.car_rental_system.maintenance.domain.entities.MaintenanceEntity;

public interface MaintenanceService {
  List<MaintenanceEntity> findAll(Pageable pageable);

  MaintenanceEntity findById(Long id);

  MaintenanceEntity save(MaintenanceEntity maintenance);

  MaintenanceEntity update(Long id, MaintenanceEntity maintenance);

  boolean existsById(Long id);

  MaintenanceEntity deleteById(Long id);
}
