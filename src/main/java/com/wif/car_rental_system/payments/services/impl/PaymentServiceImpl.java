package com.wif.car_rental_system.payments.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import com.wif.car_rental_system.payments.domain.entities.PaymentEntity;
import com.wif.car_rental_system.payments.repositories.PaymentRepository;
import com.wif.car_rental_system.payments.services.PaymentService;
import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PaymentServiceImpl implements PaymentService {

  @Autowired
  private PaymentRepository repository;

  @Override
  public List<PaymentEntity> findAll(Pageable pageable) {
    return repository.findAll();
  }

  @Override
  public PaymentEntity findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pago no encontrado"));
  }

  @Override
  public PaymentEntity save(PaymentEntity entity) {
    return repository.save(entity);
  }

  @Override
  public PaymentEntity update(Long id, PaymentEntity entity) {
    PaymentEntity entityToUpdate = this.findById(id);

    Optional.ofNullable(entity.getRental()).ifPresent(rel -> {
      RentalEntity relEntity = null; // TODO
      entityToUpdate.setRental(relEntity);
    });
    Optional.ofNullable(entity.getAmount()).ifPresent(entityToUpdate::setAmount);
    Optional.ofNullable(entity.getPaymentDate()).ifPresent(entityToUpdate::setPaymentDate);
    Optional.ofNullable(entity.getStatus()).ifPresent(entityToUpdate::setStatus);
    Optional.ofNullable(entity.getType()).ifPresent(entityToUpdate::setType);

    return repository.save(entityToUpdate);
  }

  @Override
  public boolean existsById(Long id) {
    return repository.existsById(id);
  }

  @Override
  public PaymentEntity deleteById(Long id) {
    PaymentEntity entity = this.findById(id);
    repository.deleteById(id);
    return entity;
  }

}
