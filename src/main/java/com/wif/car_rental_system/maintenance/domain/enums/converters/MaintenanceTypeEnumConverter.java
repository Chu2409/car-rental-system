package com.wif.car_rental_system.maintenance.domain.enums.converters;

import com.wif.car_rental_system.maintenance.domain.enums.MaintenanceTypeEnum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MaintenanceTypeEnumConverter implements AttributeConverter<MaintenanceTypeEnum, String> {

  @Override
  public String convertToDatabaseColumn(MaintenanceTypeEnum attribute) {
    return attribute.getLabel();
  }

  @Override
  public MaintenanceTypeEnum convertToEntityAttribute(String label) {
    return MaintenanceTypeEnum.of(label);
  }

}
