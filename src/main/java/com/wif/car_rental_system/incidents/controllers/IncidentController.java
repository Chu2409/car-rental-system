package com.wif.car_rental_system.incidents.controllers;

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

import com.wif.car_rental_system.incidents.domain.dtos.CreateIncidentReqDto;
import com.wif.car_rental_system.incidents.domain.dtos.IncidentResDto;
import com.wif.car_rental_system.incidents.domain.dtos.UpdateIncidentReqDto;
import com.wif.car_rental_system.incidents.domain.entities.IncidentEntity;
import com.wif.car_rental_system.incidents.domain.mappers.IncidentMapper;
import com.wif.car_rental_system.incidents.services.IncidentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/incidents")
public class IncidentController {

  @Autowired
  private IncidentService service;

  @Autowired
  private IncidentMapper mapper;

  @GetMapping
  public ResponseEntity<List<IncidentResDto>> findAll(@PageableDefault(sort = "id") Pageable pageable) {
    List<IncidentEntity> entities = service.findAll(pageable);

    List<IncidentResDto> responses = entities.stream().map(mapper::toRes).toList();

    return ResponseEntity.ok(responses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<IncidentResDto> findById(@PathVariable("id") Long id) {
    IncidentEntity entity = service.findById(id);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @PostMapping
  public ResponseEntity<IncidentResDto> save(@RequestBody @Valid CreateIncidentReqDto dto) {
    IncidentEntity entity = mapper.toEntity(dto);

    entity = service.save(entity);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<IncidentResDto> update(@PathVariable("id") Long id,
      @RequestBody @Valid UpdateIncidentReqDto dto) {
    IncidentEntity entity = mapper.toEntity(dto);

    entity = service.update(id, entity);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<IncidentResDto> deleteById(@PathVariable("id") Long id) {
    IncidentEntity entity = service.deleteById(id);

    return ResponseEntity.ok(mapper.toRes(entity));
  }
}
