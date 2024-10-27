package com.wif.car_rental_system.auth.domain.mappers;

import org.springframework.stereotype.Component;

import com.wif.car_rental_system.auth.domain.dtos.req.SigninReqDto;
import com.wif.car_rental_system.auth.domain.dtos.req.SignupReqDto;
import com.wif.car_rental_system.auth.domain.dtos.res.SigninResDto;
import com.wif.car_rental_system.users.domain.entities.UserEntity;
import com.wif.car_rental_system.users.domain.enums.UserRoleEnum;

@Component
public class AuthMapper {
  public UserEntity toEntity(SigninReqDto dto) {
    return UserEntity.builder()
        .email(dto.getEmail())
        .password(dto.getPassword())
        .build();
  }

  public UserEntity toEntity(SignupReqDto dto) {
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

  public SigninResDto toRes(String token) {
    return SigninResDto.builder().token(token).build();
  }
}
