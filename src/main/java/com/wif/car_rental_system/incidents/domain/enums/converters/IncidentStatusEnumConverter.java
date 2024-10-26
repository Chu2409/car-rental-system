package com.wif.car_rental_system.incidents.domain.enums.converters;

import com.wif.car_rental_system.incidents.domain.enums.IncidentStatusEnum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class IncidentStatusEnumConverter implements AttributeConverter<IncidentStatusEnum, String> {

  @Override
  public String convertToDatabaseColumn(IncidentStatusEnum attribute) {
    return attribute.getLabel();
  }

  @Override
  public IncidentStatusEnum convertToEntityAttribute(String label) {
    return IncidentStatusEnum.of(label);
  }

}
