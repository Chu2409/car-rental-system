package com.wif.car_rental_system.auth.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.wif.car_rental_system.auth.services.AuthService;
import com.wif.car_rental_system.auth.utils.EmailSenderUtil;
import com.wif.car_rental_system.auth.utils.JwtTokenUtil;
import com.wif.car_rental_system.users.domain.entities.UserEntity;
import com.wif.car_rental_system.users.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
  @Autowired
  UserRepository repository;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private EmailSenderUtil emailSenderUtil;

  @Override
  public UserEntity loadUserByUsername(String username) {
    return repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

  public UserEntity signup(UserEntity user) throws JWTVerificationException {
    if (repository.existsByEmail(user.getEmail()))
      throw new JWTVerificationException("Username already exists");

    String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
    user.setPassword(encryptedPassword);

    return repository.save(user);
  }

  @Override
  public void sendRecoveryToken(String email) {
    UserEntity user = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    String token = jwtTokenUtil.genRecoveryKeyToken(user);
    emailSenderUtil.sendEmail(email, token);
  }

  @Override
  public void resetPassword(String token, String newPassword) {
    if (!jwtTokenUtil.isRecoveryToken(token)) {
      throw new JWTVerificationException("Invalid token");
    }

    String email = jwtTokenUtil.validateToken(token);

    UserEntity user = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));

    String encryptedPassword = new BCryptPasswordEncoder().encode(newPassword);
    user.setPassword(encryptedPassword);

    repository.save(user);
  }
}
