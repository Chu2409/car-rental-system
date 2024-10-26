package com.wif.car_rental_system.users.domain.enums.converters;

import com.wif.car_rental_system.users.domain.enums.UserRoleEnum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserRoleEnumConverter implements AttributeConverter<UserRoleEnum, String> {

  @Override
  public String convertToDatabaseColumn(UserRoleEnum attribute) {
    return attribute.getLabel();
  }

  @Override
  public UserRoleEnum convertToEntityAttribute(String label) {
    return UserRoleEnum.of(label);
  }

}
