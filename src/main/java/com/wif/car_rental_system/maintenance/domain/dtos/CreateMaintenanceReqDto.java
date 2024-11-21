package com.wif.car_rental_system.maintenance.domain.dtos;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wif.car_rental_system.maintenance.domain.enums.MaintenanceStatusEnum;
import com.wif.car_rental_system.maintenance.domain.enums.MaintenanceTypeEnum;
import com.wif.car_rental_system.shared.validators.EnumValue;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class CreateMaintenanceReqDto {
  @NotNull(message = "cost is required")
  @Positive(message = "cost must be greater than 0")
  private Float cost;

  @Length(max = 255, message = "description must be less than 255 characters")
  private String description;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @JsonFormat(pattern = "MM/dd/yyyy")
  @NotNull(message = "endDate is required")
  private LocalDateTime endDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @JsonFormat(pattern = "MM/dd/yyyy")
  @NotNull(message = "startDate is required")
  private LocalDateTime startDate;

  @EnumValue(enumClass = MaintenanceStatusEnum.class, message = "Invalid status")
  @NotNull(message = "status is required")
  private String status;

  @EnumValue(enumClass = MaintenanceTypeEnum.class, message = "Invalid type")
  @NotNull(message = "type is required")
  private String type;

  @NotNull(message = "carId is required")
  @Positive(message = "carId must be positive")
  private Long carId;
}
