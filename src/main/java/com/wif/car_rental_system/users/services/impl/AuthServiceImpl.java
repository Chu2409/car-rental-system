package com.wif.car_rental_system.users.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.wif.car_rental_system.users.domain.entities.UserEntity;
import com.wif.car_rental_system.users.repositories.UserRepository;
import com.wif.car_rental_system.users.services.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
  @Autowired
  UserRepository repository;

  @Override
  public UserEntity loadUserByUsername(String username) {
    var user = repository.findByEmail(username);
    return user;
  }

  public UserEntity signup(UserEntity user) throws JWTVerificationException {
    if (repository.findByEmail(user.getEmail()) != null) {
      throw new JWTVerificationException("Username already exists");
    }

    String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
    user.setPassword(encryptedPassword);

    return repository.save(user);
  }

  // @Override
  // public String signIn(UserEntity user) {
  // var usernamePassword = new
  // UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
  // var authUser = authenticationManager.authenticate(usernamePassword);
  // var accessToken = tokenService.genAccessToken((UserEntity)
  // authUser.getPrincipal());
  // return accessToken;
  // }

}
