package com.wif.car_rental_system.cars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wif.car_rental_system.cars.domain.entities.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
  boolean existsByPlate(String plate);
}
