package com.wif.car_rental_system.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wif.car_rental_system.users.domain.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findByEmail(String email);
}
