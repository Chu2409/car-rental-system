package com.wif.car_rental_system.maintenance.domain.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wif.car_rental_system.cars.domain.dtos.CarResDto;
import com.wif.car_rental_system.cars.domain.entities.CarEntity;
import com.wif.car_rental_system.cars.domain.mappers.CarMapper;
import com.wif.car_rental_system.maintenance.domain.dtos.CreateMaintenanceReqDto;
import com.wif.car_rental_system.maintenance.domain.dtos.MaintenanceResDto;
import com.wif.car_rental_system.maintenance.domain.dtos.UpdateMaintenanceReqDto;
import com.wif.car_rental_system.maintenance.domain.entities.MaintenanceEntity;
import com.wif.car_rental_system.maintenance.domain.enums.MaintenanceStatusEnum;
import com.wif.car_rental_system.maintenance.domain.enums.MaintenanceTypeEnum;

@Component
public class MaintenanceMapper {

  @Autowired
  private CarMapper carMapper;

  public MaintenanceEntity toEntity(Long id) {
    return MaintenanceEntity.builder()
        .id(id)
        .build();
  }

  public MaintenanceEntity toEntity(CreateMaintenanceReqDto dto) {
    MaintenanceStatusEnum status = MaintenanceStatusEnum.of(dto.getStatus());
    MaintenanceTypeEnum type = MaintenanceTypeEnum.of(dto.getType());
    CarEntity car = carMapper.toEntity(dto.getCarId());

    return MaintenanceEntity.builder()
        .cost(dto.getCost())
        .description(dto.getDescription())
        .endDate(dto.getEndDate())
        .startDate(dto.getStartDate())
        .status(status)
        .type(type)
        .car(car)
        .build();
  }

  public MaintenanceEntity toEntity(UpdateMaintenanceReqDto dto) {
    MaintenanceStatusEnum status = MaintenanceStatusEnum.of(dto.getStatus());
    MaintenanceTypeEnum type = MaintenanceTypeEnum.of(dto.getType());
    CarEntity car = dto.getCarId() != null ? carMapper.toEntity(dto.getCarId()) : null;

    return MaintenanceEntity.builder()
        .cost(dto.getCost())
        .description(dto.getDescription())
        .endDate(dto.getEndDate())
        .startDate(dto.getStartDate())
        .status(status)
        .type(type)
        .car(car)
        .build();
  }

  public MaintenanceResDto toRes(MaintenanceEntity entity) {
    CarResDto car = carMapper.toRes(entity.getCar());

    return MaintenanceResDto.builder()
        .id(entity.getId())
        .cost(entity.getCost())
        .description(entity.getDescription())
        .endDate(entity.getEndDate())
        .startDate(entity.getStartDate())
        .status(entity.getStatus().getLabel())
        .type(entity.getType().getLabel())
        .car(car)
        .build();
  }
}
