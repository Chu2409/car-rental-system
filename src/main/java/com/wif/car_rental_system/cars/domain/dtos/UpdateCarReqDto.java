package com.wif.car_rental_system.cars.domain.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCarReqDto {

    @Length(max = 100, message = "Brand must be less than 100 characters")
    private String brand;

    @Length(max = 100, message = "Model must be less than 100 characters")
    private String model;

    @Length(max = 10, message = "Plate must be less than 10 characters")
    private String plate;

    @PositiveOrZero(message = "Year must be positive or zero")
    private Integer year;

    @Length(max = 30, message = "Type must be less than 30 characters")
    private String type;

    @PositiveOrZero(message = "Daily rate must be positive or zero")
    private Float dailyRate;

    @Length(max = 20, message = "Status must be less than 20 characters")
    private String status;

    @Length(max = 50, message = "Color must be less than 50 characters")
    private String color;

    @PositiveOrZero(message = "Mileage must be positive or zero")
    private Integer mileage;
    
    private String imageUrl;
    
}
