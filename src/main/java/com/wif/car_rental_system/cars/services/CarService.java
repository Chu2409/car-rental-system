package com.wif.car_rental_system.cars.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.wif.car_rental_system.cars.domain.dtos.CarFilters;
import com.wif.car_rental_system.cars.domain.entities.CarEntity;

public interface CarService {

  List<CarEntity> findAll(Pageable pageable);

  Map<String, Object> findAllWithFilters(CarFilters filters, Pageable pageable);

  CarEntity findById(Long id);

  CarEntity save(CarEntity car);

  CarEntity update(Long id, CarEntity car);

  boolean existsById(Long id);

  void deleteById(Long id);
}
