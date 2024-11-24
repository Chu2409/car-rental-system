package com.wif.car_rental_system.rates.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import com.wif.car_rental_system.rates.domain.entities.RateEntity;
import com.wif.car_rental_system.rates.repositories.RateRepository;
import com.wif.car_rental_system.rates.services.RateService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RateServiceImpl implements RateService {

  @Autowired
  private RateRepository repository;

  @Override
  public List<RateEntity> findAll(Pageable pageable) {
    return repository.findAll();
  }

  @Override
  public RateEntity findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tarifa no encontrado"));
  }

  @Override
  public RateEntity save(RateEntity entity) {
    return repository.save(entity);
  }

  @Override
  public RateEntity update(Long id, RateEntity entity) {
    RateEntity entityToUpdate = this.findById(id);

    Optional.ofNullable(entity.getCarType()).ifPresent(entityToUpdate::setCarType);
    Optional.ofNullable(entity.getBaseRate()).ifPresent(entityToUpdate::setBaseRate);
    Optional.ofNullable(entity.getPeakRate()).ifPresent(entityToUpdate::setPeakRate);
    Optional.ofNullable(entity.getStartDate()).ifPresent(entityToUpdate::setStartDate);
    Optional.ofNullable(entity.getEndDate()).ifPresent(entityToUpdate::setEndDate);
    Optional.ofNullable(entity.getActive()).ifPresent(entityToUpdate::setActive);

    return repository.save(entityToUpdate);
  }

  @Override
  public boolean existsById(Long id) {
    return repository.existsById(id);
  }

  @Override
  public RateEntity deleteById(Long id) {
    RateEntity entity = this.findById(id);
    repository.deleteById(id);
    return entity;
  }

}
