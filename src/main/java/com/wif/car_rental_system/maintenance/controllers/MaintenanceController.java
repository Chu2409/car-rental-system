package com.wif.car_rental_system.maintenance.controllers;

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

import com.wif.car_rental_system.maintenance.domain.dtos.CreateMaintenanceReqDto;
import com.wif.car_rental_system.maintenance.domain.dtos.MaintenanceResDto;
import com.wif.car_rental_system.maintenance.domain.dtos.UpdateMaintenanceReqDto;
import com.wif.car_rental_system.maintenance.domain.entities.MaintenanceEntity;
import com.wif.car_rental_system.maintenance.domain.mappers.MaintenanceMapper;
import com.wif.car_rental_system.maintenance.services.MaintenanceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

  @Autowired
  private MaintenanceService service;

  @Autowired
  private MaintenanceMapper mapper;

  @GetMapping
  public ResponseEntity<List<MaintenanceResDto>> findAll(@PageableDefault(sort = "id") Pageable pageable) {
    List<MaintenanceEntity> entities = service.findAll(pageable);

    List<MaintenanceResDto> responses = entities.stream().map(mapper::toRes).toList();

    return ResponseEntity.ok(responses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<MaintenanceResDto> findById(@PathVariable("id") Long id) {
    MaintenanceEntity entity = service.findById(id);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @PostMapping
  public ResponseEntity<MaintenanceResDto> save(@RequestBody @Valid CreateMaintenanceReqDto dto) {
    MaintenanceEntity entity = mapper.toEntity(dto);

    entity = service.save(entity);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<MaintenanceResDto> update(@PathVariable("id") Long id,
      @RequestBody @Valid UpdateMaintenanceReqDto dto) {
    MaintenanceEntity entity = mapper.toEntity(dto);

    entity = service.update(id, entity);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<MaintenanceResDto> deleteById(@PathVariable("id") Long id) {
    MaintenanceEntity entity = service.deleteById(id);

    return ResponseEntity.ok(mapper.toRes(entity));
  }
}
