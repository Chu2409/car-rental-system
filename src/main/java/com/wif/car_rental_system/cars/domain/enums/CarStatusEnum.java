package com.wif.car_rental_system.cars.domain.enums;

import java.util.stream.Stream;
import lombok.Getter;

@Getter
public enum CarStatusEnum {

  AVAILABLE(1, "Disponible"),
  RENTED(2, "Alquilado"),
  MAINTENANCE(3, "En mantenimiento");

  private final int id;
  private final String label;

  private CarStatusEnum(int id, String label) {
    this.id = id;
    this.label = label;
  }

  public static CarStatusEnum of(int id) {
    return Stream.of(CarStatusEnum.values())
        .filter(status -> status.getId() == id)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid car status id: " + id));
  }

  public static CarStatusEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(CarStatusEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid car status label: " + label));
  }
}
