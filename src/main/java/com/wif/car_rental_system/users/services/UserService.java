package com.wif.car_rental_system.users.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.wif.car_rental_system.users.domain.entities.UserEntity;

public interface UserService {
  List<UserEntity> findAll(Pageable pageable);

  List<UserEntity> findAllClients();

  UserEntity findById(Long id);

  UserEntity save(UserEntity entity);

  UserEntity update(Long id, UserEntity entity);

  boolean existsById(Long id);

  UserEntity deleteById(Long id);
}
