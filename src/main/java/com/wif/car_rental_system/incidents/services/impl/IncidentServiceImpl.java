package com.wif.car_rental_system.incidents.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import com.wif.car_rental_system.incidents.domain.entities.IncidentEntity;
import com.wif.car_rental_system.incidents.repositories.IncidentRepository;
import com.wif.car_rental_system.incidents.services.IncidentService;
import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;
import com.wif.car_rental_system.rentals.services.RentalService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class IncidentServiceImpl implements IncidentService {

  @Autowired
  private IncidentRepository repository;

  @Autowired
  private RentalService rentalService;

  @Override
  public List<IncidentEntity> findAll(Pageable pageable) {
    return repository.findAll();
  }

  @Override
  public IncidentEntity findById(Long id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Incidente no encontrado"));
  }

  @Override
  public IncidentEntity save(IncidentEntity entity) {
    return repository.save(entity);
  }

  @Override
  public IncidentEntity update(Long id, IncidentEntity entity) {
    IncidentEntity entityToUpdate = this.findById(id);

    Optional.ofNullable(entity.getRental()).ifPresent(rel -> {
      RentalEntity relEntity = rentalService.findById(rel.getId());
      entityToUpdate.setRental(relEntity);
    });
    Optional.ofNullable(entity.getDescription()).ifPresent(entityToUpdate::setDescription);
    Optional.ofNullable(entity.getPhotoEvidenceUrl()).ifPresent(entityToUpdate::setPhotoEvidenceUrl);
    Optional.ofNullable(entity.getRepairCost()).ifPresent(entityToUpdate::setRepairCost);
    Optional.ofNullable(entity.getReportedAt()).ifPresent(entityToUpdate::setReportedAt);
    Optional.ofNullable(entity.getStatus()).ifPresent(entityToUpdate::setStatus);

    return repository.save(entityToUpdate);
  }

  @Override
  public boolean existsById(Long id) {
    return repository.existsById(id);
  }

  @Override
  public IncidentEntity deleteById(Long id) {
    IncidentEntity entity = this.findById(id);
    repository.deleteById(id);
    return entity;
  }

}
