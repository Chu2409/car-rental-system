package com.wif.car_rental_system.auth.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.wif.car_rental_system.users.domain.entities.UserEntity;

public interface AuthService extends UserDetailsService {
  UserEntity signup(UserEntity user);

  void sendRecoveryToken(String email);

  void resetPassword(String token, String newPassword);
}
