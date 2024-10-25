package com.wif.car_rental_system.maintenance.domain.enums;

import java.util.stream.Stream;
import lombok.Getter;

@Getter
public enum MaintenanceTypeEnum {

  PREVENTIVE(1, "Preventivo"),
  CORRECTIVE(2, "Correctivo");

  private final int id;
  private final String label;

  private MaintenanceTypeEnum(int id, String label) {
    this.id = id;
    this.label = label;
  }

  public static MaintenanceTypeEnum of(int id) {
    return Stream.of(MaintenanceTypeEnum.values())
        .filter(status -> status.getId() == id)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid maintenance type id: " + id));
  }

  public static MaintenanceTypeEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(MaintenanceTypeEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid maintenance type label: " + label));
  }
}
