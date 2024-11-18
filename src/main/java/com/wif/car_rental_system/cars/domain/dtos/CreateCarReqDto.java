package com.wif.car_rental_system.cars.domain.dtos;

import org.hibernate.validator.constraints.Length;

import com.wif.car_rental_system.cars.domain.enums.CarStatusEnum;
import com.wif.car_rental_system.cars.domain.enums.CarTypeEnum;
import com.wif.car_rental_system.shared.validators.EnumValue;

import jakarta.validation.constraints.NotNull;
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
public class CreateCarReqDto {
  @NotNull(message = "brand is required")
  @Length(max = 100, message = "brand must be less than 100 characters")
  private String brand;

  @NotNull(message = "model is required")
  @Length(max = 100, message = "model must be lees than 100 characters")
  private String model;

  @NotNull(message = "plate is required")
  @Length(max = 10, message = "plate must be lees than 10 characters")
  private String plate;

  @NotNull(message = "year is required")
  private Integer year;

  @NotNull(message = "type is required")
  @Length(max = 30, message = "type must be lees than 30 characters")
  @EnumValue(enumClass = CarTypeEnum.class, message = "Invalid car type")
  private String type;

  @NotNull(message = "dailyRate is required")
  private Float dailyRate;

  @NotNull(message = "status is required")
  @Length(max = 20, message = "status must be lees than 20 characters")
  @EnumValue(enumClass = CarStatusEnum.class, message = "Invalid car status")
  private String status;

  @NotNull(message = "color is required")
  @Length(max = 50, message = "color must be lees than 50 characters")
  private String color;

  @NotNull(message = "mileage is required")
  private Integer mileage;

  private String imageUrl;

}
