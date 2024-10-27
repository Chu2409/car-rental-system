package com.wif.car_rental_system.auth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wif.car_rental_system.auth.domain.dtos.req.SigninReqDto;
import com.wif.car_rental_system.auth.domain.dtos.req.SignupReqDto;
import com.wif.car_rental_system.auth.domain.dtos.res.SigninResDto;
import com.wif.car_rental_system.auth.domain.mappers.AuthMapper;
import com.wif.car_rental_system.auth.services.AuthService;
import com.wif.car_rental_system.auth.utils.JwtTokenUtil;
import com.wif.car_rental_system.users.domain.dtos.res.UserResDto;
import com.wif.car_rental_system.users.domain.entities.UserEntity;
import com.wif.car_rental_system.users.domain.mappers.UserMapper;

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
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private AuthMapper mapper;

  @Autowired
  private UserMapper userMapper;

  @PostMapping("/signup")
  public ResponseEntity<UserResDto> signup(@RequestBody @Valid SignupReqDto dto) {
    UserEntity user = mapper.toEntity(dto);

    UserEntity registeredUser = service.signup(user);

    return ResponseEntity.ok(userMapper.toRes(registeredUser));
  }

  @PostMapping("/signin")
  public ResponseEntity<SigninResDto> signIn(@RequestBody @Valid SigninReqDto dto) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
    var authUser = authenticationManager.authenticate(usernamePassword);
    var accessToken = jwtTokenUtil.genAccessToken((UserEntity) authUser.getPrincipal());

    return ResponseEntity.ok(mapper.toRes(accessToken));
  }

  @PostMapping("/reset")
  public ResponseEntity<Void> requestPasswordReset(@RequestParam("email") String email) {
    service.sendRecoveryToken(email);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/reset-password")
  public ResponseEntity<Void> resetPassword(@RequestParam("token") String token,
      @RequestParam("newPassword") String newPassword) {
    service.resetPassword(token, newPassword);
    return ResponseEntity.ok().build();
  }
}
