package com.wif.car_rental_system.incidents.domain.mappers;

import org.springframework.stereotype.Component;

import com.wif.car_rental_system.incidents.domain.dtos.CreateIncidentReqDto;
import com.wif.car_rental_system.incidents.domain.dtos.IncidentResDto;
import com.wif.car_rental_system.incidents.domain.dtos.UpdateIncidentReqDto;
import com.wif.car_rental_system.incidents.domain.entities.IncidentEntity;
import com.wif.car_rental_system.incidents.domain.enums.IncidentStatusEnum;
import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;

@Component
public class IncidentMapper {

  public IncidentEntity toEntity(Long id) {
    return IncidentEntity.builder()
        .id(id)
        .build();
  }

  public IncidentEntity toEntity(CreateIncidentReqDto dto) {
    IncidentStatusEnum status = IncidentStatusEnum.of(dto.getStatus());
    RentalEntity rental = RentalEntity.builder().id(dto.getRentalId()).build();

    return IncidentEntity.builder()
        .description(dto.getDescription())
        .photoEvidenceUrl(dto.getPhotoEvidenceUrl())
        .repairCost(dto.getRepairCost())
        .reportedAt(dto.getReportedAt())
        .status(status)
        .rental(rental)
        .build();
  }

  public IncidentEntity toEntity(UpdateIncidentReqDto dto) {
    IncidentStatusEnum status = IncidentStatusEnum.of(dto.getStatus());
    RentalEntity rental = dto.getRentalId() != null ? RentalEntity.builder().id(dto.getRentalId()).build() : null;

    return IncidentEntity.builder()
        .description(dto.getDescription())
        .photoEvidenceUrl(dto.getPhotoEvidenceUrl())
        .repairCost(dto.getRepairCost())
        .reportedAt(dto.getReportedAt())
        .status(status)
        .rental(rental)
        .build();
  }

  public IncidentResDto toRes(IncidentEntity entity) {

    return IncidentResDto.builder()
        .id(entity.getId())
        .description(entity.getDescription())
        .photoEvidenceUrl(entity.getPhotoEvidenceUrl())
        .repairCost(entity.getRepairCost())
        .reportedAt(entity.getReportedAt())
        .status(entity.getStatus().getLabel())
        .build();
  }
}
