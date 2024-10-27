package com.wif.car_rental_system.cars.domain.enums;

import java.util.stream.Stream;

import com.wif.car_rental_system.shared.interfaces.EnumInterface;

public enum CarStatusEnum implements EnumInterface {
  AVAILABLE("Disponible"),
  RENTED("Alquilado"),
  MAINTENANCE("En mantenimiento");

  private final String label;

  private CarStatusEnum(String label) {
    this.label = label;
  }

  public static CarStatusEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(CarStatusEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid car status label: " + label));
  }

  public String getLabel() {
    return this.label;
  }
}
