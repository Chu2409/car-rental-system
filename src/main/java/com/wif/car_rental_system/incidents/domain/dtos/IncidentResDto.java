package com.wif.car_rental_system.incidents.domain.dtos;

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
public class IncidentResDto {
  private Long id;
  private String description;
  private Float repairCost;
  private LocalDateTime reportedAt;
  private String photoEvidenceUrl;
  private String status;

}
