package com.wif.car_rental_system.auth.domain.dtos.req;

import org.hibernate.validator.constraints.Length;

import com.wif.car_rental_system.shared.validators.EnumValue;
import com.wif.car_rental_system.users.domain.enums.UserRoleEnum;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupReqDto {
  @NotNull(message = "name is required")
  @Length(min = 3, max = 50, message = "name must be between 3 and 50 characters")
  private String name;

  @NotNull(message = "lastName is required")
  @Length(min = 3, max = 50, message = "lastName must be between 3 and 50 characters")
  private String lastName;

  @NotNull(message = "email is required")
  @Email(message = "email must be a valid email")
  private String email;

  @NotNull(message = "password is required")
  @Length(min = 5, max = 20)
  private String password;

  @Length(min = 7, max = 15, message = "phone must be between 7 and 15 characters")
  private String phone;

  @Length(min = 5, max = 255, message = "address must be between 5 and 255 characters")
  private String address;

  @NotNull(message = "role is required")
  @EnumValue(enumClass = UserRoleEnum.class)
  private String role;

  @Default
  private Boolean active = true;
}
