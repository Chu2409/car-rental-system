package com.wif.car_rental_system.users.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wif.car_rental_system.users.domain.entities.UserEntity;
import com.wif.car_rental_system.users.services.AuthService;
import com.wif.car_rental_system.users.services.TokenService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthService service;

  @Autowired
  private TokenService tokenService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @PostMapping("/signup")
  public ResponseEntity<UserEntity> postMethodName(@RequestBody UserEntity entity) {
    UserEntity registeredUser = service.signup(entity);

    return ResponseEntity.ok(registeredUser);
  }

  @PostMapping("/signin")
  public ResponseEntity<String> signIn(@RequestBody @Valid UserEntity entity) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(entity.getEmail(), entity.getPassword());
    var authUser = authenticationManager.authenticate(usernamePassword);
    var accessToken = tokenService.genAccessToken((UserEntity) authUser.getPrincipal());
    return ResponseEntity.ok(accessToken);
  }
}