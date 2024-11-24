package com.wif.car_rental_system.rates.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.wif.car_rental_system.rates.domain.entities.RateEntity;

public interface RateService {
  List<RateEntity> findAll(Pageable pageable);

  RateEntity findById(Long id);

  RateEntity save(RateEntity maintenance);

  RateEntity update(Long id, RateEntity maintenance);

  boolean existsById(Long id);

  RateEntity deleteById(Long id);
}
