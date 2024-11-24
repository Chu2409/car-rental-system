package com.wif.car_rental_system.rentals.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;

public interface RentalService {
  List<RentalEntity> findAll(Pageable pageable);

  RentalEntity findById(Long id);

  RentalEntity save(RentalEntity entity);

  RentalEntity update(Long id, RentalEntity entity);

  boolean existsById(Long id);

  RentalEntity deleteById(Long id);
}
