package com.wif.car_rental_system.maintenance.domain.dtos;

import java.time.LocalDateTime;

import com.wif.car_rental_system.cars.domain.dtos.CarResDto;

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
public class MaintenanceResDto {
  private Long id;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private String description;
  private Float cost;
  private String status;
  private String type;
  private CarResDto car;

}
