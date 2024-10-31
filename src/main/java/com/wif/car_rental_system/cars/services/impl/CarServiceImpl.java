package com.wif.car_rental_system.cars.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wif.car_rental_system.cars.domain.dtos.CarFilters;
import com.wif.car_rental_system.cars.domain.entities.CarEntity;
import com.wif.car_rental_system.cars.repositories.CarRepository;
import com.wif.car_rental_system.cars.repositories.specifications.CarSpecifications;
import com.wif.car_rental_system.cars.services.CarService;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;;

@Service
public class CarServiceImpl implements CarService {

  @Autowired
  private CarRepository carRepository;

  @Override
  public List<CarEntity> findAll(Pageable pageable) {
    return carRepository.findAll(pageable).getContent();
  }

  @Override
  public List<CarEntity> findAllWithFilters(CarFilters filters, Pageable pageable) {
    return carRepository.findAll(CarSpecifications.withFilters(filters), pageable).getContent();
  }

  @Override
  public CarEntity findById(Long id) {
    return carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Car not found"));
  }

  @Override
  public CarEntity save(CarEntity car) {
    if (carRepository.existsByPlate(car.getPlate()))
      throw new EntityExistsException("Plate already exists");

    return carRepository.save(car);
  }

  @Override
  public CarEntity update(Long id, CarEntity car) {
    CarEntity carToUpdate = findById(id);

    Optional.ofNullable(car.getPlate()).ifPresent(plate -> {
      if (carRepository.existsByPlate(plate))
        throw new EntityExistsException("Plate already exists");
      carToUpdate.setPlate(plate);
    });
    Optional.ofNullable(car.getBrand()).ifPresent(carToUpdate::setBrand);
    Optional.ofNullable(car.getModel()).ifPresent(carToUpdate::setModel);
    Optional.ofNullable(car.getYear()).ifPresent(carToUpdate::setYear);
    Optional.ofNullable(car.getColor()).ifPresent(carToUpdate::setColor);
    Optional.ofNullable(car.getMileage()).ifPresent(carToUpdate::setMileage);
    Optional.ofNullable(car.getStatus()).ifPresent(carToUpdate::setStatus);
    Optional.ofNullable(car.getType()).ifPresent(carToUpdate::setType);
    Optional.ofNullable(car.getDailyRate()).ifPresent(carToUpdate::setDailyRate);
    Optional.ofNullable(car.getImageUrl()).ifPresent(carToUpdate::setImageUrl);

    return carRepository.save(carToUpdate);
  }

  @Override
  public boolean existsById(Long id) {
    return carRepository.existsById(id);
  }

  @Override
  public void deleteById(Long id) {
    CarEntity car = findById(id);
    carRepository.delete(car);
  }
}
