package com.wif.car_rental_system.cars.domain.enums;

import java.util.stream.Stream;

import com.wif.car_rental_system.shared.interfaces.EnumInterface;

public enum CarTypeEnum implements EnumInterface {
  ECONOMY("Económico"),
  SEDAN("Sedán"),
  COMPACT_SUV("SUV Compacto"),
  LARGE_SUV("SUV Grande"),
  LUXURY("Lujo"),
  PICKUP("Camioneta"),
  MINIVAN("Minivan"),
  SPORT("Deportivo");

  private final String label;

  private CarTypeEnum(String label) {
    this.label = label;
  }

  public static CarTypeEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(CarTypeEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid car type label: " + label));
  }

  public String getLabel() {
    return this.label;
  }
}
