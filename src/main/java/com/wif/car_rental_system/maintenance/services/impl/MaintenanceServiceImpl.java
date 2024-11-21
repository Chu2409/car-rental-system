package com.wif.car_rental_system.maintenance.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import com.wif.car_rental_system.cars.domain.entities.CarEntity;
import com.wif.car_rental_system.cars.services.CarService;
import com.wif.car_rental_system.maintenance.domain.entities.MaintenanceEntity;
import com.wif.car_rental_system.maintenance.repositories.MaintenanceRepository;
import com.wif.car_rental_system.maintenance.services.MaintenanceService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

  @Autowired
  private MaintenanceRepository repository;

  @Autowired
  private CarService carService;

  @Override
  public List<MaintenanceEntity> findAll(Pageable pageable) {
    return repository.findAll();
  }

  @Override
  public MaintenanceEntity findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Mantenimiento no encontrado"));
  }

  @Override
  public MaintenanceEntity save(MaintenanceEntity maintenance) {
    CarEntity car = carService.findById(maintenance.getCar().getId());
    maintenance.setCar(car);

    return repository.save(maintenance);
  }

  @Override
  public MaintenanceEntity update(Long id, MaintenanceEntity maintenance) {
    MaintenanceEntity maintenanceToUpdate = this.findById(id);

    Optional.ofNullable(maintenance.getCar()).ifPresent(car -> {
      CarEntity carEntity = carService.findById(car.getId());
      maintenanceToUpdate.setCar(carEntity);
    });
    Optional.ofNullable(maintenance.getCost()).ifPresent(maintenanceToUpdate::setCost);
    Optional.ofNullable(maintenance.getDescription()).ifPresent(maintenanceToUpdate::setDescription);
    Optional.ofNullable(maintenance.getEndDate()).ifPresent(maintenanceToUpdate::setEndDate);
    Optional.ofNullable(maintenance.getStartDate()).ifPresent(maintenanceToUpdate::setStartDate);
    Optional.ofNullable(maintenance.getStatus()).ifPresent(maintenanceToUpdate::setStatus);
    Optional.ofNullable(maintenance.getType()).ifPresent(maintenanceToUpdate::setType);

    return repository.save(maintenanceToUpdate);
  }

  @Override
  public boolean existsById(Long id) {
    return repository.existsById(id);
  }

  @Override
  public MaintenanceEntity deleteById(Long id) {
    MaintenanceEntity maintenance = this.findById(id);
    repository.deleteById(id);
    return maintenance;
  }

}
