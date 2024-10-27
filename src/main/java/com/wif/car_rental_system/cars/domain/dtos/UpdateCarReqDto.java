package com.wif.car_rental_system.cars.domain.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCarReqDto {
  @Length(max = 100, message = "brand must be less than 100 characters")
  private String brand;

  @Length(max = 100, message = "model must be less than 100 characters")
  private String model;

  @Length(max = 10, message = "plate must be less than 10 characters")
  private String plate;

  @PositiveOrZero(message = "year must be positive or zero")
  private Integer year;

  @Length(max = 30, message = "type must be less than 30 characters")
  private String type;

  @PositiveOrZero(message = "daily rate must be positive or zero")
  private Float dailyRate;

  @Length(max = 20, message = "status must be less than 20 characters")
  private String status;

  @Length(max = 50, message = "color must be less than 50 characters")
  private String color;

  @PositiveOrZero(message = "mileage must be positive or zero")
  private Integer mileage;

  private String imageUrl;

}
