package com.wif.car_rental_system.rates.domain.dtos;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wif.car_rental_system.cars.domain.enums.CarTypeEnum;
import com.wif.car_rental_system.shared.validators.EnumValue;

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
public class UpdateRateReqDto {
  @PositiveOrZero(message = "baseRate must be positive or zero")
  private Float baseRate;

  @PositiveOrZero(message = "peakRate must be positive or zero")
  private Float peakRate;

  @EnumValue(enumClass = CarTypeEnum.class, message = "carType must be one of the types")
  private String carType;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @JsonFormat(pattern = "MM/dd/yyyy")
  private LocalDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @JsonFormat(pattern = "MM/dd/yyyy")
  private LocalDateTime endDate;

  private Boolean active;
}
