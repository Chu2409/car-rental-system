package com.wif.car_rental_system.cars.controllers;

import java.util.List;
import java.util.Map;

import org.hibernate.internal.util.collections.LinkedIdentityHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wif.car_rental_system.cars.domain.dtos.CarFilters;
import com.wif.car_rental_system.cars.domain.dtos.CarResDto;
import com.wif.car_rental_system.cars.domain.dtos.CreateCarReqDto;
import com.wif.car_rental_system.cars.domain.dtos.UpdateCarReqDto;
import com.wif.car_rental_system.cars.domain.entities.CarEntity;
import com.wif.car_rental_system.cars.domain.mappers.CarMapper;
import com.wif.car_rental_system.cars.services.CarService;

import jakarta.validation.Valid;

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

  @GetMapping("/{id}")
  public ResponseEntity<CarResDto> findById(@PathVariable("id") Long id) {
    CarEntity car = carService.findById(id);

    return ResponseEntity.ok(mapper.toRes(car));
  }

  @GetMapping("/filter")
  public ResponseEntity<Map<String, Object>> findAll(
      @Valid CarFilters filters,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int perPage) {
    Pageable pageable = PageRequest.of(page, perPage);

    Map<String, Object> result = carService.findAllWithFilters(filters, pageable);

    @SuppressWarnings("unchecked")
    List<CarEntity> carEntities = (List<CarEntity>) result.get("items");
    List<CarResDto> carsRes = carEntities.stream().map(mapper::toRes).toList();

    result.put("items", carsRes);

    return ResponseEntity.ok(result);
  }

  @PostMapping
  public ResponseEntity<CarResDto> save(@RequestBody @Valid CreateCarReqDto carDto) {
    CarEntity car = mapper.toEntity(carDto);

    car = carService.save(car);

    return ResponseEntity.ok(mapper.toRes(car));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<CarResDto> update(@PathVariable("id") Long id, @RequestBody @Valid UpdateCarReqDto carDto) {
    CarEntity car = mapper.toEntity(carDto);

    car = carService.update(id, car);

    return ResponseEntity.ok(mapper.toRes(car));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteById(@PathVariable("id") Long id) {
    carService.deleteById(id);
    LinkedIdentityHashMap<String, String> response = new LinkedIdentityHashMap<>();
    response.put("message", "Car deleted");

    return ResponseEntity.ok(response);
  }

}
