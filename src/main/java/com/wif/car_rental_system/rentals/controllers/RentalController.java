package com.wif.car_rental_system.rentals.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wif.car_rental_system.rentals.domain.dtos.CreateRentalReqDto;
import com.wif.car_rental_system.rentals.domain.dtos.RentalResDto;
import com.wif.car_rental_system.rentals.domain.dtos.UpdateRentalReqDto;
import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;
import com.wif.car_rental_system.rentals.domain.mappers.RentalMapper;
import com.wif.car_rental_system.rentals.services.RentalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rentals")
public class RentalController {

  @Autowired
  private RentalService service;

  @Autowired
  private RentalMapper mapper;

  @GetMapping
  public ResponseEntity<List<RentalResDto>> findAll(@PageableDefault(sort = "id") Pageable pageable) {
    List<RentalEntity> entities = service.findAll(pageable);

    List<RentalResDto> responses = entities.stream().map(mapper::toRes).toList();

    return ResponseEntity.ok(responses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<RentalResDto> findById(@PathVariable("id") Long id) {
    RentalEntity entity = service.findById(id);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @PostMapping
  public ResponseEntity<RentalResDto> save(@RequestBody @Valid CreateRentalReqDto dto) {
    RentalEntity entity = mapper.toEntity(dto);

    entity = service.save(entity);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<RentalResDto> update(@PathVariable("id") Long id,
      @RequestBody @Valid UpdateRentalReqDto dto) {
    RentalEntity entity = mapper.toEntity(dto);

    entity = service.update(id, entity);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<RentalResDto> deleteById(@PathVariable("id") Long id) {
    RentalEntity entity = service.deleteById(id);

    return ResponseEntity.ok(mapper.toRes(entity));
  }
}
