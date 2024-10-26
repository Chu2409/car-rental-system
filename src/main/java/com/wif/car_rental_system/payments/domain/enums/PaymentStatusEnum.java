package com.wif.car_rental_system.payments.domain.enums;

import java.util.stream.Stream;
import lombok.Getter;

@Getter
public enum PaymentStatusEnum {

  PENDING(1, "Pendiente"),
  COMPLETED(2, "Completado"),
  CANCELED(3, "Cancelado");

  private final int id;
  private final String label;

  private PaymentStatusEnum(int id, String label) {
    this.id = id;
    this.label = label;
  }

  public static PaymentStatusEnum of(int id) {
    return Stream.of(PaymentStatusEnum.values())
        .filter(status -> status.getId() == id)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid payment status id: " + id));
  }

  public static PaymentStatusEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(PaymentStatusEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid payment status label: " + label));
  }
}
