package com.wif.car_rental_system.incidents.domain.enums;

import java.util.stream.Stream;
import lombok.Getter;

@Getter
public enum IncidentStatusEnum {

  PENDING(1, "Pendiente"),
  PROCESSED(2, "Procesado"),
  RESOLVED(3, "Resuelto");

  private final int id;
  private final String label;

  private IncidentStatusEnum(int id, String label) {
    this.id = id;
    this.label = label;
  }

  public static IncidentStatusEnum of(int id) {
    return Stream.of(IncidentStatusEnum.values())
        .filter(status -> status.getId() == id)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid incident status id: " + id));
  }

  public static IncidentStatusEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(IncidentStatusEnum.values())
        .filter(status -> status.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid incident status label: " + label));
  }
}
