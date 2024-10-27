package com.wif.car_rental_system.rentals.domain.enums;

import java.util.stream.Stream;

import com.wif.car_rental_system.shared.interfaces.EnumInterface;

public enum RentalStatusEnum implements EnumInterface {
  RESERVED("Reservado"),
  ACTIVE("Activo"),
  COMPLETED("Completado"),
  CANCELED("Cancelado");

  private final String label;

  private RentalStatusEnum(String label) {
    this.label = label;
  }

  public static RentalStatusEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(RentalStatusEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid rental status label: " + label));
  }

  public String getLabel() {
    return this.label;
  }
}
