package com.wif.car_rental_system.payments.domain.enums;

import java.util.stream.Stream;
import lombok.Getter;

@Getter
public enum PaymentTypeEnum {

  CASH(1, "Efectivo"),
  CARD(2, "Tarjeta"),
  TRANSFER(3, "Transferencia");

  private final int id;
  private final String label;

  private PaymentTypeEnum(int id, String label) {
    this.id = id;
    this.label = label;
  }

  public static PaymentStatusEnum of(int id) {
    return Stream.of(PaymentStatusEnum.values())
        .filter(status -> status.getId() == id)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid payment type id: " + id));
  }

  public static PaymentTypeEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(PaymentTypeEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid payment type label: " + label));
  }
}
