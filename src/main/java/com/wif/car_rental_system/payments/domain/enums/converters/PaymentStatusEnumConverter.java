package com.wif.car_rental_system.payments.domain.enums.converters;

import com.wif.car_rental_system.payments.domain.enums.PaymentStatusEnum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PaymentStatusEnumConverter implements AttributeConverter<PaymentStatusEnum, String> {

  @Override
  public String convertToDatabaseColumn(PaymentStatusEnum attribute) {
    return attribute.getLabel();
  }

  @Override
  public PaymentStatusEnum convertToEntityAttribute(String label) {
    return PaymentStatusEnum.of(label);
  }

}
