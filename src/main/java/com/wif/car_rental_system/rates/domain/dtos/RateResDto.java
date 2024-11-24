package com.wif.car_rental_system.rates.domain.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RateResDto {
  private Long id;
  private String carType;
  private Float baseRate;
  private Float peakRate;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Boolean active;

}
