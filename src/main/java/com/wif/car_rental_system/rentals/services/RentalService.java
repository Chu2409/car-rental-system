package com.wif.car_rental_system.rentals.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;

public interface RentalService {
  List<RentalEntity> findAll(Pageable pageable);

  Map<String, Object> findAllByUserId(Long userId, Pageable pageable);

  RentalEntity findById(Long id);

  RentalEntity save(RentalEntity entity);

  RentalEntity update(Long id, RentalEntity entity);

  boolean existsById(Long id);

  RentalEntity deleteById(Long id);
}
