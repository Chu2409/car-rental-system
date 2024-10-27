package com.wif.car_rental_system.maintenance.domain.enums;

import java.util.stream.Stream;

import com.wif.car_rental_system.shared.interfaces.EnumInterface;

public enum MaintenanceTypeEnum implements EnumInterface {
  PREVENTIVE("Preventivo"),
  CORRECTIVE("Correctivo");

  private final String label;

  private MaintenanceTypeEnum(String label) {

    this.label = label;
  }

  public static MaintenanceTypeEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(MaintenanceTypeEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid maintenance type label: " + label));
  }

  public String getLabel() {
    return this.label;
  }
}
