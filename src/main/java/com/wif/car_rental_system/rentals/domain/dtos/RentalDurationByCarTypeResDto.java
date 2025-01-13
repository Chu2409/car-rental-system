package com.wif.car_rental_system.rentals.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder    

public class RentalDurationByCarTypeResDto {
    private String carType;
    private Long averageDurationDays;
    private Long totalRentals;
    private Long shortestRental;
    private Long longestRental;
}
