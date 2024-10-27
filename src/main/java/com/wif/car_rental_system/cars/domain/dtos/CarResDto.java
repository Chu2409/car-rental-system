package com.wif.car_rental_system.cars.domain.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarResDto {
  private Long id;
  private String brand;
  private String model;
  private String plate;
  private Integer year;
  private String type;
  private Float dailyRate;
  private String status;
  private String color;
  private Integer mileage;
  private String imageUrl;
}
