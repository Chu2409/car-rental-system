package com.wif.car_rental_system.maintenance.domain.enums;

import java.util.stream.Stream;
import lombok.Getter;

@Getter
public enum MaintenanceStatusEnum {

  SCHEDULED(1, "Programado"),
  IN_PROGRESS(2, "En progreso"),
  COMPLETED(3, "Completado");

  private final int id;
  private final String label;

  private MaintenanceStatusEnum(int id, String label) {
    this.id = id;
    this.label = label;
  }

  public static MaintenanceStatusEnum of(int id) {
    return Stream.of(MaintenanceStatusEnum.values())
        .filter(status -> status.getId() == id)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid maintenance status id: " + id));
  }

  public static MaintenanceStatusEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(MaintenanceStatusEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid maintenance status label: " + label));
  }
}
