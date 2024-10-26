package com.wif.car_rental_system.cars.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wif.car_rental_system.cars.domain.entities.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    Page<CarEntity> findAllByActiveTrue(Pageable pageable);
    
    Optional<CarEntity> findByIdAndActiveTrue(Long id);
}
