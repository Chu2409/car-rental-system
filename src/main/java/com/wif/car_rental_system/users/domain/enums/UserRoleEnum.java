package com.wif.car_rental_system.users.domain.enums;

import java.util.stream.Stream;

import com.wif.car_rental_system.shared.interfaces.EnumInterface;

public enum UserRoleEnum implements EnumInterface {
  ADMIN("Administrador"),
  EMPLOYEE("Empleado"),
  CUSTOMER("Cliente");

  private final String label;

  private UserRoleEnum(String label) {
    this.label = label;
  }

  public static UserRoleEnum of(String label) {
    if (label == null)
      return null;

    return Stream.of(UserRoleEnum.values())
        .filter(role -> role.getLabel().equals(label))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid user role label: " + label));
  }

  public String getLabel() {
    return this.label;
  }
}
