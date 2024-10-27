package com.wif.car_rental_system.users.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wif.car_rental_system.users.domain.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findByEmail(String email);

  Boolean existsByEmail(String email);
}
