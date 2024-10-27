package com.wif.car_rental_system.shared.validators;

import java.util.List;
import java.util.stream.Stream;

import com.wif.car_rental_system.shared.interfaces.EnumInterface;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValueValidator
    implements ConstraintValidator<EnumValue, String> {
  private List<String> acceptedValues;

  @Override
  public void initialize(EnumValue constraint) {
    this.acceptedValues = Stream.of(constraint.enumClass().getEnumConstants()).map(
        e -> ((EnumInterface) e).getLabel()).toList();

  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null)
      return true;

    return acceptedValues.contains(value);
  }

}
