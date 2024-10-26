package com.wif.car_rental_system.maintenance.domain.enums.converters;

import com.wif.car_rental_system.maintenance.domain.enums.MaintenanceStatusEnum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MaintenanceStatusEnumConverter implements AttributeConverter<MaintenanceStatusEnum, String> {

  @Override
  public String convertToDatabaseColumn(MaintenanceStatusEnum attribute) {
    return attribute.getLabel();
  }

  @Override
  public MaintenanceStatusEnum convertToEntityAttribute(String label) {
    return MaintenanceStatusEnum.of(label);
  }

}
