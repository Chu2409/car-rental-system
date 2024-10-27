package com.wif.car_rental_system.cars.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wif.car_rental_system.cars.domain.dtos.CarResDto;
import com.wif.car_rental_system.cars.domain.entities.CarEntity;
import com.wif.car_rental_system.cars.domain.mappers.CarMapper;
import com.wif.car_rental_system.cars.services.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarMapper mapper;

    @GetMapping
    public ResponseEntity<List<CarResDto>> findAll(@PageableDefault(sort = "id") Pageable pageable) {
        List<CarEntity> cars = carService.findAll(pageable);

        List<CarResDto> carsRes = cars.stream().map(mapper::toRes).toList();

        return ResponseEntity.ok(carsRes);
    }

    @


    
    
}
