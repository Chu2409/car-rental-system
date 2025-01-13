package com.wif.car_rental_system.rentals.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wif.car_rental_system.rentals.domain.dtos.IncomeByCarTypeResDto;
import com.wif.car_rental_system.rentals.domain.dtos.MostRentedCarsResDto;
import com.wif.car_rental_system.rentals.domain.dtos.RentalByCarResDto;
import com.wif.car_rental_system.rentals.domain.dtos.RentalDurationByCarTypeResDto;
import com.wif.car_rental_system.rentals.domain.mappers.RentalReportsMapper;
import com.wif.car_rental_system.rentals.services.RentalService;

import lombok.extern.java.Log;


@RestController
@Log
@RequestMapping("/rentals/reports")
public class RentalReportsController {
  @Autowired
  private RentalService service;

  @Autowired
  private RentalReportsMapper mapper;

  @GetMapping("/car-rentals-by-type")
    public ResponseEntity<List<RentalByCarResDto>> getCarRentalsByType() {
      List<Object[]> results = service.getCarRentalsByType();
      List<RentalByCarResDto> distribution = mapper.toReportDtoList(results);
      return ResponseEntity.ok(distribution);
    }
  
  @GetMapping("/total-income-by-car-type")
  public ResponseEntity<List<IncomeByCarTypeResDto>> getTotalIncomeByCarType() {
    List<Object[]> results = service.getTotalIncomeByCarType();
    List<IncomeByCarTypeResDto> incomeByCarType = mapper.toIncomeByCarTypeDtoList(results);
    return ResponseEntity.ok(incomeByCarType);
  }
    
  @GetMapping("/average-duration-by-car-type")
    public ResponseEntity<List<RentalDurationByCarTypeResDto>> getAverageDurationByCarType() {
        List<Object[]> results = service.getAverageDurationByCarType();
        List<RentalDurationByCarTypeResDto> durationByCarType = 
            mapper.toRentalDurationDtoList(results);
        return ResponseEntity.ok(durationByCarType);
  }

  @GetMapping("/most-rented-cars")
    public ResponseEntity<List<MostRentedCarsResDto>> getMostRentedCars() {
        List<Object[]> results = service.getMostRentedCars();
        List<MostRentedCarsResDto> mostRentedCars = mapper.toMostRentedCarsDtoList(results);
        return ResponseEntity.ok(mostRentedCars);
  }
  
}
