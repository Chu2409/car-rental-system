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

  @Query("SELECT r.car.type, COUNT(r) " +
           "FROM rentals r " +
           "WHERE r.car.type IS NOT NULL " +
           "GROUP BY r.car.type " +
           "ORDER BY COUNT(r) DESC")
    List<Object[]> countRentalsByCarType();

    @Query("SELECT " +
           "r.car.type as carType, " +
           "COUNT(r) as totalRentals, " +
           "COALESCE(SUM(r.total), 0.0) as totalIncome " +
           "FROM rentals r " +
           "WHERE r.status <> 'CANCELED' " +
           "GROUP BY r.car.type " +
           "ORDER BY totalIncome DESC")
    List<Object[]> findTotalIncomeByCarType();

    @Query("SELECT " +
    "r.car.type as carType, " +
    "CAST(AVG(TIMESTAMPDIFF(DAY, r.startDate, COALESCE(r.actualEndDate, r.endDate))) AS LONG) as avgDuration, " +
    "COUNT(r) as totalRentals, " +
    "CAST(MIN(TIMESTAMPDIFF(DAY, r.startDate, COALESCE(r.actualEndDate, r.endDate))) AS LONG) as minDuration, " +
    "CAST(MAX(TIMESTAMPDIFF(DAY, r.startDate, COALESCE(r.actualEndDate, r.endDate))) AS LONG) as maxDuration " +
    "FROM rentals r " +
    "GROUP BY r.car.type " +
    "ORDER BY avgDuration DESC")
  List<Object[]> findAverageDurationByCarType();

  @Query("SELECT " +
       "r.car.type as carType, " +
       "r.car.brand, " +
       "r.car.model, " +  
       "COUNT(r) as rental_count, " +
       "COALESCE(SUM(r.total), 0.0) as total_revenue " +
       "FROM rentals r " +
       "WHERE r.status <> 'CANCELED' " +
       "GROUP BY r.car.type, r.car.brand, r.car.model " +
       "ORDER BY rental_count DESC " +
       "LIMIT 5")
    List<Object[]> findMostRentedCars();
}
