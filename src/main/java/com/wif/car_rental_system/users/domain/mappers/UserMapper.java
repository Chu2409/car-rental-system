package com.wif.car_rental_system.users.domain.mappers;

import org.springframework.stereotype.Component;

import com.wif.car_rental_system.users.domain.dtos.res.UserResDto;
import com.wif.car_rental_system.users.domain.entities.UserEntity;

@Component
public class UserMapper {
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
