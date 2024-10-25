package com.wif.car_rental_system.cars.domain.enums;

import java.util.stream.Stream;
import lombok.Getter;

@Getter
public enum CarTypeEnum {

  ECONOMY(1, "Económico"),
  SEDAN(2, "Sedán"),
  COMPACT_SUV(3, "SUV Compacto"),
  LARGE_SUV(4, "SUV Grande"),
  LUXURY(5, "Lujo"),
  PICKUP(6, "Camioneta"),
  MINIVAN(7, "Minivan"),
  SPORT(8, "Deportivo");

  private final int id;
  private final String label;

  private CarTypeEnum(int id, String label) {
    this.id = id;
    this.label = label;
  }

  public static CarTypeEnum of(int id) {
    return Stream.of(CarTypeEnum.values())
        .filter(status -> status.getId() == id)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid car type id: " + id));
  }

  public static CarTypeEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(CarTypeEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid car type label: " + label));
  }
}
