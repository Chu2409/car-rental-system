package com.wif.car_rental_system.rates.controllers;

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

import com.wif.car_rental_system.rates.domain.dtos.CreateRateReqDto;
import com.wif.car_rental_system.rates.domain.dtos.RateResDto;
import com.wif.car_rental_system.rates.domain.dtos.UpdateRateReqDto;
import com.wif.car_rental_system.rates.domain.entities.RateEntity;
import com.wif.car_rental_system.rates.domain.mappers.RateMapper;
import com.wif.car_rental_system.rates.services.RateService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rates")
public class RateController {

  @Autowired
  private RateService service;

  @Autowired
  private RateMapper mapper;

  @GetMapping
  public ResponseEntity<List<RateResDto>> findAll(@PageableDefault(sort = "id") Pageable pageable) {
    List<RateEntity> entities = service.findAll(pageable);

    List<RateResDto> responses = entities.stream().map(mapper::toRes).toList();

    return ResponseEntity.ok(responses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<RateResDto> findById(@PathVariable("id") Long id) {
    RateEntity entity = service.findById(id);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @PostMapping
  public ResponseEntity<RateResDto> save(@RequestBody @Valid CreateRateReqDto dto) {
    RateEntity entity = mapper.toEntity(dto);

    entity = service.save(entity);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<RateResDto> update(@PathVariable("id") Long id,
      @RequestBody @Valid UpdateRateReqDto dto) {
    RateEntity entity = mapper.toEntity(dto);

    entity = service.update(id, entity);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<RateResDto> deleteById(@PathVariable("id") Long id) {
    RateEntity entity = service.deleteById(id);

    return ResponseEntity.ok(mapper.toRes(entity));
  }
}
