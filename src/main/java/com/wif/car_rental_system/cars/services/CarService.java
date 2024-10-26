package com.wif.car_rental_system.cars.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.wif.car_rental_system.cars.domain.entities.CarEntity;

public interface CarService {
    List<CarEntity> findAll(Pageable pageable, boolean includeInactive);
    
    CarEntity findById(Long id, boolean includeInactive);

    CarEntity save(CarEntity car);
    
    CarEntity update(Long id, CarEntity car);

    boolean existsById(Long id);
    
    CarEntity deleteById(Long id);
}
