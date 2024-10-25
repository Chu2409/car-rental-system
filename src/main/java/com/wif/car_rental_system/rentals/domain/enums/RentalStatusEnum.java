package com.wif.car_rental_system.rentals.domain.enums;

import java.util.stream.Stream;
import lombok.Getter;

@Getter
public enum RentalStatusEnum {

  RESERVED(1, "Reservado"),
  ACTIVE(2, "Activo"),
  COMPLETED(3, "Completado"),
  CANCELED(3, "Cancelado");

  private final int id;
  private final String label;

  private RentalStatusEnum(int id, String label) {
    this.id = id;
    this.label = label;
  }

  public static RentalStatusEnum of(int id) {
    return Stream.of(RentalStatusEnum.values())
        .filter(status -> status.getId() == id)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid rental status id: " + id));
  }

  public static RentalStatusEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(RentalStatusEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid rental status label: " + label));
  }
}
