package com.wif.car_rental_system.payments.domain.enums;

import java.util.stream.Stream;

import com.wif.car_rental_system.shared.interfaces.EnumInterface;

public enum PaymentTypeEnum implements EnumInterface {
  CASH("Efectivo"),
  CARD("Tarjeta"),
  TRANSFER("Transferencia");

  private final String label;

  private PaymentTypeEnum(String label) {

    this.label = label;
  }

  public static PaymentTypeEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(PaymentTypeEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid payment type label: " + label));
  }

  public String getLabel() {
    return this.label;
  }
}
