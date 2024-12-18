package com.wif.car_rental_system.rentals.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;

@Repository
public interface RentalRepository extends JpaRepository<RentalEntity, Long> {
  List<RentalEntity> findAllByUserId(Long userId, Pageable pageable);
  Long countAllByUserId(Long userId);
}
