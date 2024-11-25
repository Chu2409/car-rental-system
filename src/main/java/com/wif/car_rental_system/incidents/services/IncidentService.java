package com.wif.car_rental_system.incidents.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.wif.car_rental_system.incidents.domain.entities.IncidentEntity;

public interface IncidentService {
  List<IncidentEntity> findAll(Pageable pageable);

  IncidentEntity findById(Long id);

  IncidentEntity save(IncidentEntity entity);

  IncidentEntity update(Long id, IncidentEntity entity);

  boolean existsById(Long id);

  IncidentEntity deleteById(Long id);
}
