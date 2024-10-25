package com.wif.car_rental_system.cars.domain.entities;

import com.wif.car_rental_system.cars.domain.enums.CarStatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "cars")
public class CarEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, length = 100)
  private String brand;

  @Column(nullable = false, length = 100)
  private String model;

  @Column(nullable = false, length = 10, unique = true)
  private String plate;

  @Column(nullable = false)
  private int year;

  @Column(nullable = false, length = 100)
  private String type;

  @Column(nullable = false, name = "daily_rate")
  private Float dailyRate;

  @Column(nullable = false, length = 20)
  private CarStatusEnum status;

  @Column(nullable = false, length = 50)
  private String color;

  @Column(nullable = false)
  private int mileage;

  @Column(name = "image_url")
  private String imageUrl;
}
