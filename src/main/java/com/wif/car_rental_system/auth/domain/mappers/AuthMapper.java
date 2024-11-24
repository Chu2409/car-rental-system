package com.wif.car_rental_system.auth.domain.mappers;

import org.springframework.stereotype.Component;

import com.wif.car_rental_system.auth.domain.dtos.res.SigninResDto;

@Component
public class AuthMapper {

  public SigninResDto toRes(String token) {
    return SigninResDto.builder().token(token).build();
  }
}
