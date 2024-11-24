package com.wif.car_rental_system.payments.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.wif.car_rental_system.payments.domain.entities.PaymentEntity;

public interface PaymentService {
  List<PaymentEntity> findAll(Pageable pageable);

  PaymentEntity findById(Long id);

  PaymentEntity save(PaymentEntity entity);

  PaymentEntity update(Long id, PaymentEntity entity);

  boolean existsById(Long id);

  PaymentEntity deleteById(Long id);
}
