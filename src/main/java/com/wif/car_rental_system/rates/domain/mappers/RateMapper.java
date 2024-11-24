package com.wif.car_rental_system.rates.domain.mappers;

import org.springframework.stereotype.Component;

import com.wif.car_rental_system.cars.domain.enums.CarTypeEnum;
import com.wif.car_rental_system.rates.domain.dtos.CreateRateReqDto;
import com.wif.car_rental_system.rates.domain.dtos.RateResDto;
import com.wif.car_rental_system.rates.domain.dtos.UpdateRateReqDto;
import com.wif.car_rental_system.rates.domain.entities.RateEntity;

@Component
public class RateMapper {
  public RateEntity toEntity(Long id) {
    return RateEntity.builder()
        .id(id)
        .build();
  }

  public RateEntity toEntity(CreateRateReqDto dto) {
    CarTypeEnum type = CarTypeEnum.of(dto.getCarType());

    return RateEntity.builder()
        .baseRate(dto.getBaseRate())
        .peakRate(dto.getPeakRate())
        .carType(type)
        .startDate(dto.getStartDate())
        .endDate(dto.getEndDate())
        .active(dto.getActive())
        .build();
  }

  public RateEntity toEntity(UpdateRateReqDto dto) {
    CarTypeEnum type = CarTypeEnum.of(dto.getCarType());

    return RateEntity.builder()
        .baseRate(dto.getBaseRate())
        .peakRate(dto.getPeakRate())
        .carType(type)
        .startDate(dto.getStartDate())
        .endDate(dto.getEndDate())
        .active(dto.getActive())
        .build();
  }

  public RateResDto toRes(RateEntity entity) {

    return RateResDto.builder()
        .id(entity.getId())
        .carType(entity.getCarType().getLabel())
        .baseRate(entity.getBaseRate())
        .peakRate(entity.getPeakRate())
        .startDate(entity.getStartDate())
        .endDate(entity.getEndDate())
        .active(entity.getActive())
        .build();
  }
}
