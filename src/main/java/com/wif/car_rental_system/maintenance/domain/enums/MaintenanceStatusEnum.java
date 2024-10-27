package com.wif.car_rental_system.maintenance.domain.enums;

import java.util.stream.Stream;

import com.wif.car_rental_system.shared.interfaces.EnumInterface;

public enum MaintenanceStatusEnum implements EnumInterface {
  SCHEDULED("Programado"),
  IN_PROGRESS("En progreso"),
  COMPLETED("Completado");

  private final String label;

  private MaintenanceStatusEnum(String label) {
    this.label = label;
  }

  public static MaintenanceStatusEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(MaintenanceStatusEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid maintenance status label: " + label));
  }

  public String getLabel() {
    return this.label;
  }
}
