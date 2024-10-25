package com.wif.car_rental_system.cars.domain.enums.converters;

import com.wif.car_rental_system.cars.domain.enums.CarTypeEnum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CarTypeEnumConverter implements AttributeConverter<CarTypeEnum, String> {

  @Override
  public String convertToDatabaseColumn(CarTypeEnum attribute) {
    return attribute.getLabel();
  }

  @Override
  public CarTypeEnum convertToEntityAttribute(String label) {
    return CarTypeEnum.of(label);
  }

}
