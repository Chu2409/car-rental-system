package com.wif.car_rental_system.payments.domain.enums;

import java.util.stream.Stream;

import com.wif.car_rental_system.shared.interfaces.EnumInterface;

public enum PaymentStatusEnum implements EnumInterface {
  PENDING("Pendiente"),
  COMPLETED("Completado"),
  CANCELED("Cancelado");

  private final String label;

  private PaymentStatusEnum(String label) {
    this.label = label;
  }

  public static PaymentStatusEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(PaymentStatusEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid payment status label: " + label));
  }

  public String getLabel() {
    return this.label;
  }
}
