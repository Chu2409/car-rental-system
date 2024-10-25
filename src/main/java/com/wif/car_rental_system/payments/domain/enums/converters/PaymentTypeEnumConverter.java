package com.wif.car_rental_system.payments.domain.enums.converters;

import com.wif.car_rental_system.payments.domain.enums.PaymentTypeEnum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PaymentTypeEnumConverter implements AttributeConverter<PaymentTypeEnum, String> {

  @Override
  public String convertToDatabaseColumn(PaymentTypeEnum attribute) {
    return attribute.getLabel();
  }

  @Override
  public PaymentTypeEnum convertToEntityAttribute(String label) {
    return PaymentTypeEnum.of(label);
  }

}
