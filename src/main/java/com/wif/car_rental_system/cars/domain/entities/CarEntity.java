package com.wif.car_rental_system.cars.domain.entities;

import java.util.ArrayList;
import java.util.List;

import com.wif.car_rental_system.cars.domain.enums.CarStatusEnum;
import com.wif.car_rental_system.cars.domain.enums.CarTypeEnum;
import com.wif.car_rental_system.maintenance.domain.entities.MaintenanceEntity;
import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder.Default;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cars")
public class CarEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String brand;

  @Column(nullable = false, length = 100)
  private String model;

  @Column(nullable = false, length = 10, unique = true)
  private String plate;

  @Column(nullable = false)
  private Integer year;

  @Column(nullable = false, length = 30)
  private CarTypeEnum type;

  @Column(nullable = false)
  private Float dailyRate;

  @Column(nullable = false, length = 20)
  private CarStatusEnum status;

  @Column(nullable = false, length = 50)
  private String color;

  @Column(nullable = false)
  private Integer mileage;

  @Column
  private String imageUrl;

  @OneToMany(mappedBy = "car")
  @Default
  private List<MaintenanceEntity> maintenance = new ArrayList<>();

  @OneToMany(mappedBy = "car")
  @Default
  private List<RentalEntity> rentals = new ArrayList<>();

}
