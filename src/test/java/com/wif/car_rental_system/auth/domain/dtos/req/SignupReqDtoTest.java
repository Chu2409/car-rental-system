package com.wif.car_rental_system.auth.domain.dtos.req;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class SignupReqDtoTest {
  private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  private final Validator validator = factory.getValidator();

  @Test
  void whenAllFieldsAreValidThenNoViolations() {
    SignupReqDto dto = SignupReqDto.builder()
        .name("John")
        .lastName("Doe")
        .email("john.doe@example.com")
        .password("password123")
        .phone("1234567")
        .address("123 Main St")
        .role("Administrador")
        .active(true)
        .build();

    Set<ConstraintViolation<SignupReqDto>> violations = validator.validate(dto);
    assertTrue(violations.isEmpty());
  }
}
