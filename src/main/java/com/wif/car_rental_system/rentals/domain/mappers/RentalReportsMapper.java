package com.wif.car_rental_system.rentals.domain.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.wif.car_rental_system.cars.domain.enums.CarTypeEnum;
import com.wif.car_rental_system.rentals.domain.dtos.IncomeByCarTypeResDto;
import com.wif.car_rental_system.rentals.domain.dtos.MostRentedCarsResDto;
import com.wif.car_rental_system.rentals.domain.dtos.RentalByCarResDto;
import com.wif.car_rental_system.rentals.domain.dtos.RentalDurationByCarTypeResDto;

@Component
public class RentalReportsMapper {
    public RentalByCarResDto toReportDto(Object[] result) {
        CarTypeEnum type = (CarTypeEnum) result[0];
        Long count = (Long) result[1];
        
        return RentalByCarResDto.builder()
            .type(type.getLabel())
            .quantity(String.valueOf(count))
            .build();
    }

    public List<RentalByCarResDto> toReportDtoList(List<Object[]> results) {
        return results.stream()
            .map(this::toReportDto)
            .collect(Collectors.toList());
    }

    public IncomeByCarTypeResDto toIncomeByCarTypeDto(Object[] result) {
        CarTypeEnum carType = (CarTypeEnum) result[0];
        Long totalRentals = (Long) result[1];
        Double totalIncome = (Double) result[2];
        Double averageIncome = totalRentals > 0 ? totalIncome / totalRentals : 0.0;
        
        return IncomeByCarTypeResDto.builder()
            .carType(carType.getLabel())
            .totalIncome(String.format("%.2f", totalIncome))
            .totalRentals(String.valueOf(totalRentals))
            .averagePerRental(String.format("%.2f", averageIncome))
            .build();
    }

    public List<IncomeByCarTypeResDto> toIncomeByCarTypeDtoList(List<Object[]> results) {
        return results.stream()
            .map(this::toIncomeByCarTypeDto)
            .collect(Collectors.toList());
    }

    public RentalDurationByCarTypeResDto toRentalDurationDto(Object[] result) {
        CarTypeEnum carType = (CarTypeEnum) result[0];
        Long avgDuration = ((Number) result[1]).longValue();
        Long totalRentals = ((Number) result[2]).longValue();
        Long minDuration = ((Number) result[3]).longValue();
        Long maxDuration = ((Number) result[4]).longValue();
        
        return RentalDurationByCarTypeResDto.builder()
            .carType(carType.getLabel())
            .averageDurationDays(avgDuration)
            .totalRentals(totalRentals)
            .shortestRental(minDuration)
            .longestRental(maxDuration)
            .build();
    }

    public List<RentalDurationByCarTypeResDto> toRentalDurationDtoList(List<Object[]> results) {
        return results.stream()
            .map(this::toRentalDurationDto)
            .collect(Collectors.toList());
    }

    public MostRentedCarsResDto toMostRentedCarsDto(Object[] result) {
        CarTypeEnum carType = (CarTypeEnum) result[0];
        String carBrand = (String) result[1];
        String carModel = (String) result[2];
        Long totalRentals = (Long) result[3];
        Double revenue = (Double) result[4];

        
        
        return MostRentedCarsResDto.builder()
            .carType(carType.getLabel())
            .carBrand(carBrand)
            .carModel(carModel)
            .totalRentals(String.valueOf(totalRentals))
            .revenue(String.format("%.2f", revenue))
            .build();
    }

    public List<MostRentedCarsResDto> toMostRentedCarsDtoList(List<Object[]> results) {
        return results.stream()
            .map(this::toMostRentedCarsDto)
            .collect(Collectors.toList());
    }
}
