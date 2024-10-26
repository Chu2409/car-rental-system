package com.wif.car_rental_system.users.services;

import com.wif.car_rental_system.users.domain.entities.UserEntity;

public interface TokenService {
  String genAccessToken(UserEntity user);

  String genRecoveryKeyToken(UserEntity user);

  String validateToken(String token);
}
