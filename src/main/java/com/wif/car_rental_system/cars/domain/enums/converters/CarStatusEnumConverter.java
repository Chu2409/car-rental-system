package com.wif.car_rental_system.cars.domain.enums.converters;

import com.wif.car_rental_system.cars.domain.enums.CarStatusEnum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CarStatusEnumConverter implements AttributeConverter<CarStatusEnum, String> {

  @Override
  public String convertToDatabaseColumn(CarStatusEnum attribute) {
    return attribute.getLabel();
  }

  @Override
  public CarStatusEnum convertToEntityAttribute(String label) {
    return CarStatusEnum.of(label);
  }

}
