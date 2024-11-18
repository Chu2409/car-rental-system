package com.wif.car_rental_system.cars.domain.dtos;

import com.wif.car_rental_system.cars.domain.enums.CarStatusEnum;
import com.wif.car_rental_system.cars.domain.enums.CarTypeEnum;
import com.wif.car_rental_system.shared.validators.EnumValue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarFilters {
    private String search;

    @EnumValue(enumClass = CarTypeEnum.class, message = "Invalid car type")
    private String type;

    @EnumValue(enumClass = CarStatusEnum.class, message = "Invalid car status")
    private String status;

    private Integer year;
    private String brand;
    private Double minPrice;
    private Double maxPrice;
    private String orderBy;
    private Integer page;
    private Integer perPage;
}
