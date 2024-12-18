package com.wif.car_rental_system.rentals.domain.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wif.car_rental_system.cars.domain.dtos.CarResDto;
import com.wif.car_rental_system.cars.domain.entities.CarEntity;
import com.wif.car_rental_system.cars.domain.mappers.CarMapper;
import com.wif.car_rental_system.rentals.domain.dtos.CreateRentalReqDto;
import com.wif.car_rental_system.rentals.domain.dtos.RentalResDto;
import com.wif.car_rental_system.rentals.domain.dtos.UpdateRentalReqDto;
import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;
import com.wif.car_rental_system.rentals.domain.enums.RentalStatusEnum;
import com.wif.car_rental_system.users.domain.dtos.UserResDto;
import com.wif.car_rental_system.users.domain.entities.UserEntity;
import com.wif.car_rental_system.users.domain.mappers.UserMapper;

@Component
public class RentalMapper {

  @Autowired
  private CarMapper carMapper;

  @Autowired
  private UserMapper userMapper;

  public RentalEntity toEntity(Long id) {
    return RentalEntity.builder()
        .id(id)
        .build();
  }

  public RentalEntity toEntity(CreateRentalReqDto dto) {
    RentalStatusEnum status = RentalStatusEnum.of(dto.getStatus());
    CarEntity car = CarEntity.builder().id(dto.getCarId()).build();
    UserEntity user = UserEntity.builder().id(dto.getUserId()).build();
    UserEntity employee = dto.getEmployeeId() != null ? UserEntity.builder().id(dto.getEmployeeId()).build() : null;

    return RentalEntity.builder()
        .actualEndDate(dto.getActualEndDate())
        .startDate(dto.getStartDate())
        .endDate(dto.getEndDate())
        .status(status)
        .total(dto.getTotal())
        .car(car)
        .user(user)
        .employee(employee)
        .build();
  }

  public RentalEntity toEntity(UpdateRentalReqDto dto) {
    RentalStatusEnum status = RentalStatusEnum.of(dto.getStatus());
    CarEntity car = dto.getCarId() != null ? CarEntity.builder().id(dto.getCarId()).build() : null;
    UserEntity user = dto.getUserId() != null ? UserEntity.builder().id(dto.getUserId()).build() : null;
    UserEntity employee = dto.getEmployeeId() != null ? UserEntity.builder().id(dto.getEmployeeId()).build() : null;

    return RentalEntity.builder()
        .actualEndDate(dto.getActualEndDate())
        .startDate(dto.getStartDate())
        .endDate(dto.getEndDate())
        .status(status)
        .total(dto.getTotal())
        .car(car)
        .user(user)
        .employee(employee)
        .build();
  }

  public RentalResDto toRes(RentalEntity entity) {
    CarResDto car = carMapper.toRes(entity.getCar());
    UserResDto user = userMapper.toRes(entity.getUser());
    UserResDto employee = entity.getEmployee() != null ? userMapper.toRes(entity.getEmployee()) : null;

    return RentalResDto.builder()
        .id(entity.getId())
        .actualEndDate(entity.getActualEndDate())
        .startDate(entity.getStartDate())
        .endDate(entity.getEndDate())
        .status(entity.getStatus().getLabel())
        .total(entity.getTotal())
        .car(car)
        .user(user)
        .employee(employee)
        .build();
  }
}
