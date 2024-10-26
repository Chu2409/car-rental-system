package com.wif.car_rental_system.cars.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wif.car_rental_system.cars.domain.entities.CarEntity;
import com.wif.car_rental_system.cars.repositories.CarRepository;
import com.wif.car_rental_system.cars.services.CarService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarEntity> findAll(Pageable pageable, boolean includeInactive) {
        if(includeInactive)
            return carRepository.findAll(pageable).getContent();
        
        return carRepository.findAllByActiveTrue(pageable).getContent();
    }

    @Override
    public CarEntity findById(Long id, boolean includeInactive) {
        if (includeInactive)
            return carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Car not found"));
            
        return carRepository.findByIdAndActiveTrue(id).orElseThrow(() -> new EntityNotFoundException("Car active not found"));
    }

    @Override
    public CarEntity save(CarEntity car) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public CarEntity update(Long id, CarEntity car) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public CarEntity deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    
}
