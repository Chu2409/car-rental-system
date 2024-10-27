package com.wif.car_rental_system.cars.domain.mappers;

import org.springframework.stereotype.Component;

import com.wif.car_rental_system.cars.domain.dtos.CarResDto;
import com.wif.car_rental_system.cars.domain.dtos.CreateCarReqDto;
import com.wif.car_rental_system.cars.domain.entities.CarEntity;
import com.wif.car_rental_system.cars.domain.enums.CarStatusEnum;
import com.wif.car_rental_system.cars.domain.enums.CarTypeEnum;

@Component
public class CarMapper {

    public CarEntity toEntity(Long id) {
        return CarEntity.builder()
            .id(id)
            .build();
    }

    public CarEntity toEntity(CreateCarReqDto dto) {

        CarTypeEnum type = CarTypeEnum.of(dto.getType());
        CarStatusEnum status = CarStatusEnum.of(dto.getStatus());


        return CarEntity.builder()
            .brand(dto.getBrand())
            .model(dto.getModel())
            .color(dto.getColor())
            .plate(dto.getPlate())
            .year(dto.getYear())
            .type(type)
            .status(status)
            .dailyRate(dto.getDailyRate())
            .mileage(dto.getMileage())
            .imageUrl(dto.getImageUrl())
            .build();
    }

    public CarResDto toRes(CarEntity entity) {
        String status = entity.getStatus().getLabel();
        String type = entity.getType().getLabel();
        return CarResDto.builder()
            .id(entity.getId())
            .brand(entity.getBrand())
            .model(entity.getModel())
            .color(entity.getColor())
            .plate(entity.getPlate())
            .year(entity.getYear())
            .type(type)
            .dailyRate(entity.getDailyRate())
            .status(status)
            .mileage(entity.getMileage())
            .imageUrl(entity.getImageUrl())
            .build();
    }
    
}
