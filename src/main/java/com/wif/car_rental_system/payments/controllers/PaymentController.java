package com.wif.car_rental_system.payments.controllers;

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

import com.wif.car_rental_system.payments.domain.dtos.CreatePaymentReqDto;
import com.wif.car_rental_system.payments.domain.dtos.PaymentResDto;
import com.wif.car_rental_system.payments.domain.dtos.UpdatePaymentReqDto;
import com.wif.car_rental_system.payments.domain.entities.PaymentEntity;
import com.wif.car_rental_system.payments.domain.mappers.PaymentMapper;
import com.wif.car_rental_system.payments.services.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/payments")
public class PaymentController {

  @Autowired
  private PaymentService service;

  @Autowired
  private PaymentMapper mapper;

  @GetMapping
  public ResponseEntity<List<PaymentResDto>> findAll(@PageableDefault(sort = "id") Pageable pageable) {
    List<PaymentEntity> entities = service.findAll(pageable);

    List<PaymentResDto> responses = entities.stream().map(mapper::toRes).toList();

    return ResponseEntity.ok(responses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PaymentResDto> findById(@PathVariable("id") Long id) {
    PaymentEntity entity = service.findById(id);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @PostMapping
  public ResponseEntity<PaymentResDto> save(@RequestBody @Valid CreatePaymentReqDto dto) {
    PaymentEntity entity = mapper.toEntity(dto);

    entity = service.save(entity);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<PaymentResDto> update(@PathVariable("id") Long id,
      @RequestBody @Valid UpdatePaymentReqDto dto) {
    PaymentEntity entity = mapper.toEntity(dto);

    entity = service.update(id, entity);

    return ResponseEntity.ok(mapper.toRes(entity));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<PaymentResDto> deleteById(@PathVariable("id") Long id) {
    PaymentEntity entity = service.deleteById(id);

    return ResponseEntity.ok(mapper.toRes(entity));
  }
}
