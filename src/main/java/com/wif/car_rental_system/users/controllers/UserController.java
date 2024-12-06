package com.wif.car_rental_system.users.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wif.car_rental_system.users.domain.dtos.CreateUserReqDto;
import com.wif.car_rental_system.users.domain.dtos.UpdateUserReqDto;
import com.wif.car_rental_system.users.domain.dtos.UserResDto;
import com.wif.car_rental_system.users.domain.entities.UserEntity;
import com.wif.car_rental_system.users.domain.mappers.UserMapper;
import com.wif.car_rental_system.users.services.UserService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
// @RolesAllowed({ "ADMIN", "CUSTOMER" })
public class UserController {

  @Autowired
  private UserService service;

  @Autowired
  private UserMapper mapper;

  @GetMapping
  public ResponseEntity<List<UserResDto>> findAll(@PageableDefault(sort = "id") Pageable pageable) {
    List<UserEntity> entities = service.findAll(pageable);

    List<UserResDto> responses = entities.stream().map(mapper::toRes).toList();

    return ResponseEntity.ok(responses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResDto> findById(@PathVariable("id") Long id) {
    UserEntity entity = service.findById(id);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @PostMapping
  public ResponseEntity<UserResDto> save(@RequestBody @Valid CreateUserReqDto dto) {
    UserEntity entity = mapper.toEntity(dto);

    entity = service.save(entity);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<UserResDto> update(@PathVariable("id") Long id,
      @RequestBody @Valid UpdateUserReqDto dto) {
    UserEntity entity = mapper.toEntity(dto);

    entity = service.update(id, entity);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<UserResDto> deleteById(@PathVariable("id") Long id) {
    UserEntity entity = service.deleteById(id);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

}
