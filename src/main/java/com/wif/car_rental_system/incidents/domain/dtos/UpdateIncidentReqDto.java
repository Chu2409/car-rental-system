package com.wif.car_rental_system.incidents.domain.dtos;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wif.car_rental_system.incidents.domain.enums.IncidentStatusEnum;
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
public class UpdateIncidentReqDto {
  @PositiveOrZero(message = "repairCost must be positive or zero")
  private Float repairCost;

  private String description;

  private String photoEvidenceUrl;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  @JsonFormat(pattern = "MM/dd/yyyy")
  private LocalDateTime reportedAt;

  @EnumValue(enumClass = IncidentStatusEnum.class, message = "status must be one of the types")
  private String status;

  @PositiveOrZero(message = "rentalId must be positive or zero")
  private Long rentalId;

}
