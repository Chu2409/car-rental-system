package com.wif.car_rental_system.users.domain.enums;

import java.util.stream.Stream;
import lombok.Getter;

@Getter
public enum UserRoleEnum {

  ADMIN(1, "Administrador"),
  EMPLOYEE(2, "Empleado"),
  CLIENT(3, "Cliente");

  private final int id;
  private final String label;

  private UserRoleEnum(int id, String label) {
    this.id = id;
    this.label = label;
  }

  public static UserRoleEnum of(int id) {
    return Stream.of(UserRoleEnum.values())
        .filter(role -> role.getId() == id)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid user role id: " + id));
  }

  public static UserRoleEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(UserRoleEnum.values())
        .filter(role -> role.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid user role label: " + label));
  }
}
