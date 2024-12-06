package com.wif.car_rental_system.rentals.domain.dtos;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wif.car_rental_system.rentals.domain.enums.RentalStatusEnum;
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
public class UpdateRentalReqDto {
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @JsonFormat(pattern = "dd/MM/yyyy':'HH:mm")
  private LocalDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @JsonFormat(pattern = "dd/MM/yyyy':'HH:mm")
  private LocalDateTime endDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @JsonFormat(pattern = "dd/MM/yyyy':'HH:mm")
  private LocalDateTime actualEndDate;

  @EnumValue(enumClass = RentalStatusEnum.class, message = "status must be one of the types")
  private String status;

  @PositiveOrZero(message = "total must be positive or zero")
  private Float total;

  @PositiveOrZero(message = "carId must be positive or zero")
  private Long carId;

  @PositiveOrZero(message = "employeeId must be positive or zero")
  private Long employeeId;

  @PositiveOrZero(message = "userId must be positive or zero")
  private Long userId;

}
