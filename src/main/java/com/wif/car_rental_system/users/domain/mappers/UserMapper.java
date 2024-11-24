package com.wif.car_rental_system.users.domain.mappers;

import org.springframework.stereotype.Component;

import com.wif.car_rental_system.users.domain.dtos.CreateUserReqDto;
import com.wif.car_rental_system.users.domain.dtos.UpdateUserReqDto;
import com.wif.car_rental_system.users.domain.dtos.UserResDto;
import com.wif.car_rental_system.users.domain.entities.UserEntity;
import com.wif.car_rental_system.users.domain.enums.UserRoleEnum;

@Component
public class UserMapper {
  public UserEntity toEntity(Long id) {
    return UserEntity.builder()
        .id(id)
        .build();
  }

  public UserEntity toEntity(CreateUserReqDto dto) {
    UserRoleEnum role = UserRoleEnum.of(dto.getRole());

    return UserEntity.builder()
        .name(dto.getName())
        .lastName(dto.getLastName())
        .email(dto.getEmail())
        .password(dto.getPassword())
        .phone(dto.getPhone())
        .address(dto.getAddress())
        .role(role)
        .active(dto.getActive())
        .build();
  }

  public UserEntity toEntity(UpdateUserReqDto dto) {
    UserRoleEnum role = UserRoleEnum.of(dto.getRole());

    return UserEntity.builder()
        .name(dto.getName())
        .lastName(dto.getLastName())
        .email(dto.getEmail())
        .password(dto.getPassword())
        .phone(dto.getPhone())
        .address(dto.getAddress())
        .role(role)
        .active(dto.getActive())
        .build();
  }

  public UserResDto toRes(UserEntity entity) {
    return UserResDto.builder()
        .id(entity.getId())
        .name(entity.getName())
        .lastName(entity.getLastName())
        .email(entity.getEmail())
        .phone(entity.getPhone())
        .address(entity.getAddress())
        .role(entity.getRole().getLabel())
        .createdAt(entity.getCreatedAt())
        .active(entity.getActive())
        .build();
  }
}
