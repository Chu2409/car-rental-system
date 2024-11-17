package com.wif.car_rental_system.auth.domain.dtos.req;

import org.hibernate.validator.constraints.Length;

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
public class ResetPasswordReqDto {
  @NotNull(message = "newPassword is required")
  @Length(min = 5, max = 20, message = "newPassword must be between 5 and 20 characters")
  private String newPassword;
}