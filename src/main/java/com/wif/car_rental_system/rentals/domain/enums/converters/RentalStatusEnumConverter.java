package com.wif.car_rental_system.rentals.domain.enums.converters;

import com.wif.car_rental_system.rentals.domain.enums.RentalStatusEnum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RentalStatusEnumConverter implements AttributeConverter<RentalStatusEnum, String> {

  @Override
  public String convertToDatabaseColumn(RentalStatusEnum attribute) {
    return attribute.getLabel();
  }

  @Override
  public RentalStatusEnum convertToEntityAttribute(String label) {
    return RentalStatusEnum.of(label);
  }

}
