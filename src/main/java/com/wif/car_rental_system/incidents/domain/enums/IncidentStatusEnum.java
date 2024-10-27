package com.wif.car_rental_system.incidents.domain.enums;

import java.util.stream.Stream;

import com.wif.car_rental_system.shared.interfaces.EnumInterface;

public enum IncidentStatusEnum implements EnumInterface {
  PENDING("Pendiente"),
  PROCESSED("Procesado"),
  RESOLVED("Resuelto");

  private final String label;

  private IncidentStatusEnum(String label) {
    this.label = label;
  }

  public static IncidentStatusEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(IncidentStatusEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid incident status label: " + label));
  }

  public String getLabel() {
    return this.label;
  }
}
