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
public class MostRentedCarsResDto {
    private String carBrand;
    private String carModel;
    private String carType;
    private String totalRentals;
    private String revenue;
}
