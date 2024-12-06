package com.wif.car_rental_system.rentals.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import com.wif.car_rental_system.cars.domain.entities.CarEntity;
import com.wif.car_rental_system.cars.services.CarService;
import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;
import com.wif.car_rental_system.rentals.repositories.RentalRepository;
import com.wif.car_rental_system.rentals.services.RentalService;
import com.wif.car_rental_system.users.domain.entities.UserEntity;
import com.wif.car_rental_system.users.services.UserService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RentalServiceImpl implements RentalService {

  @Autowired
  private RentalRepository repository;

  @Autowired
  private CarService carService;

  @Autowired
  private UserService userService;

  @Override
  public List<RentalEntity> findAll(Pageable pageable) {
    return repository.findAll();
  }

  @Override
  public RentalEntity findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Alquiler no encontrado"));
  }

  @Override
  public RentalEntity save(RentalEntity entity) {
    CarEntity car = carService.findById(entity.getCar().getId());
    UserEntity user = userService.findById(entity.getUser().getId());
    UserEntity employee = userService.findById(entity.getEmployee().getId());

    entity.setCar(car);
    entity.setUser(user);
    entity.setEmployee(employee);

    return repository.save(entity);
  }

  @Override
  public RentalEntity update(Long id, RentalEntity entity) {
    RentalEntity entityToUpdate = this.findById(id);

    Optional.ofNullable(entity.getCar()).ifPresent(rel -> {
      CarEntity relEntity = carService.findById(rel.getId());
      entityToUpdate.setCar(relEntity);
    });
    Optional.ofNullable(entity.getEmployee()).ifPresent(rel -> {
      UserEntity relEntity = userService.findById(rel.getId());
      entityToUpdate.setEmployee(relEntity);
    });
    Optional.ofNullable(entity.getUser()).ifPresent(rel -> {
      UserEntity relEntity = userService.findById(rel.getId());
      entityToUpdate.setUser(relEntity);
    });
    Optional.ofNullable(entity.getActualEndDate()).ifPresent(entityToUpdate::setActualEndDate);
    Optional.ofNullable(entity.getEndDate()).ifPresent(entityToUpdate::setEndDate);
    Optional.ofNullable(entity.getStartDate()).ifPresent(entityToUpdate::setStartDate);
    Optional.ofNullable(entity.getStatus()).ifPresent(entityToUpdate::setStatus);
    Optional.ofNullable(entity.getTotal()).ifPresent(entityToUpdate::setTotal);

    return repository.save(entityToUpdate);
  }

  @Override
  public boolean existsById(Long id) {
    return repository.existsById(id);
  }

  @Override
  public RentalEntity deleteById(Long id) {
    RentalEntity entity = this.findById(id);
    repository.deleteById(id);
    return entity;
  }

}
