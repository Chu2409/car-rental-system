package com.wif.car_rental_system.rentals.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;

@Repository
public interface RentalRepository extends JpaRepository<RentalEntity, Long> {
  List<RentalEntity> findAllByUserId(Long userId, Pageable pageable);

  Long countAllByUserId(Long userId);

  @Query("SELECT r FROM rentals r " +
           "WHERE r.car.id = :carId " +
           "AND r.status NOT IN ('CANCELLED', 'COMPLETED', 'PAID') " +
           "AND NOT (r.endDate < :startDate OR r.startDate > :endDate)")
    List<RentalEntity> findOverlappingRentals(
        @Param("carId") Long carId,
        @Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate
    );
}
