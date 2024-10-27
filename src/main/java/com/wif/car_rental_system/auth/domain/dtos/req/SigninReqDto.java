package com.wif.car_rental_system.auth.domain.dtos.req;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SigninReqDto {
  @NotNull(message = "email is required")
  @Email(message = "email must be a valid email")
  private String email;

  @NotNull(message = "password is required")
  @Length(min = 5, max = 20)
  private String password;
}
