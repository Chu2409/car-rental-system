package com.wif.car_rental_system.users.services.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wif.car_rental_system.users.domain.entities.UserEntity;
import com.wif.car_rental_system.users.domain.enums.UserRoleEnum;
import com.wif.car_rental_system.users.repositories.UserRepository;
import com.wif.car_rental_system.users.services.UserService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository repository;

  @Override
  public List<UserEntity> findAll(Pageable pageable) {
    return repository.findAll();
  }

  @Override
  public List<UserEntity> findAllClients() {
    List<UserEntity> entities = repository.findAll();

    List<UserEntity> clients = entities.stream().filter(entity -> entity.getRole().equals(UserRoleEnum.CUSTOMER)).toList();
    return clients;
  }

  @Override
  public UserEntity findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
  }

  @Override
  public UserEntity save(UserEntity entity) {
    String encryptedPassword = new BCryptPasswordEncoder().encode(entity.getPassword());
    entity.setPassword(encryptedPassword);

    return repository.save(entity);
  }

  @Override
  public UserEntity update(Long id, UserEntity entity) {
    UserEntity entityToUpdate = this.findById(id);

    Optional.ofNullable(entity.getActive()).ifPresent(entityToUpdate::setActive);
    Optional.ofNullable(entity.getAddress()).ifPresent(entityToUpdate::setAddress);
    Optional.ofNullable(entity.getCreatedAt()).ifPresent(entityToUpdate::setCreatedAt);
    Optional.ofNullable(entity.getEmail()).ifPresent(entityToUpdate::setEmail);
    Optional.ofNullable(entity.getLastName()).ifPresent(entityToUpdate::setLastName);
    Optional.ofNullable(entity.getName()).ifPresent(entityToUpdate::setName);
    Optional.ofNullable(entity.getPassword()).ifPresent((password) -> {
      String encryptedPassword = new BCryptPasswordEncoder().encode(password);
      entityToUpdate.setPassword(encryptedPassword);
    });
    Optional.ofNullable(entity.getPhone()).ifPresent(entityToUpdate::setPhone);
    Optional.ofNullable(entity.getRole()).ifPresent(entityToUpdate::setRole);

    return repository.save(entityToUpdate);
  }

  @Override
  public boolean existsById(Long id) {
    return repository.existsById(id);
  }

  @Override
  public UserEntity deleteById(Long id) {
    UserEntity entity = this.findById(id);
    repository.deleteById(id);
    return entity;
  }

}
