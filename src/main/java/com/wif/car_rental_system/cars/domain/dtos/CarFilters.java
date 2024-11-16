package com.wif.car_rental_system.cars.domain.dtos;

import com.wif.car_rental_system.cars.domain.enums.CarStatusEnum;
import com.wif.car_rental_system.cars.domain.enums.CarTypeEnum;

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
  private CarTypeEnum type;
  private CarStatusEnum status;
  private Integer year;
  private String brand;
  private Double minPrice;
  private Double maxPrice;
  private String orderBy;
  private Integer page;
  private Integer perPage;
}
