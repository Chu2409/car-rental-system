package com.wif.car_rental_system.auth.domain.dtos.req;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.wif.car_rental_system.users.domain.dtos.CreateUserReqDto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class SignupReqDtoTest {
  private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  private final Validator validator = factory.getValidator();

  @Test
  void whenAllFieldsAreValidThenNoViolations() {
    CreateUserReqDto dto = CreateUserReqDto.builder()
        .name("John")
        .lastName("Doe")
        .email("john.doe@example.com")
        .password("password123")
        .phone("1234567")
        .address("123 Main St")
        .role("Administrador")
        .active(true)
        .build();

    Set<ConstraintViolation<CreateUserReqDto>> violations = validator.validate(dto);
    assertTrue(violations.isEmpty());
  }
}
