package com.wif.car_rental_system.cars.domain.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCarReqDto {

    @NotNull(message = "Brand is required")
    @Length(max = 100, message = "Brand must be less than 100 characters")
    private String brand;

    @NotNull(message = "Model is required")
    @Length(max = 100, message = "Model must be lees than 100 characters")
    private String model;

    @NotNull(message = "Plate is required")
    @Length(max =  10, message = " Plate must be lees than 10 characters" )
    private String plate;

    @NotNull(message = "Year is required")
    private Integer year;

    @NotNull(message = "Type is required")
    @Length(max = 30, message = "Type must be lees than 30 characters")
    private String type;

    @NotNull(message = "DailyRate is required")
    private Float dailyRate;

    @NotNull(message = "Status is required")
    @Length(max = 20, message = "Status must be lees than 20 characters")
    private String status;

    @NotNull(message = "Color is required")
    @Length(max = 50, message = "Color must be lees than 50 characters")
    private String color;

    @NotNull(message = "Mileage is required")
    private Integer mileage;
    
    private String imageUrl;
    
}
