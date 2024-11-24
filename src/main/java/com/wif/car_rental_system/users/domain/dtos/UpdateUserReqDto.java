package com.wif.car_rental_system.users.domain.dtos;

import org.hibernate.validator.constraints.Length;

import com.wif.car_rental_system.shared.validators.EnumValue;
import com.wif.car_rental_system.users.domain.enums.UserRoleEnum;

import jakarta.validation.constraints.Email;
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
public class UpdateUserReqDto {
  @Length(min = 3, max = 50, message = "name must be between 3 and 50 characters")
  private String name;

  @Length(min = 3, max = 50, message = "lastName must be between 3 and 50 characters")
  private String lastName;

  @Email(message = "email must be a valid email")
  private String email;

  @Length(min = 5, max = 20)
  private String password;

  @Length(min = 7, max = 15, message = "phone must be between 7 and 15 characters")
  private String phone;

  @Length(min = 5, max = 255, message = "address must be between 5 and 255 characters")
  private String address;

  @EnumValue(enumClass = UserRoleEnum.class)
  private String role;

  private Boolean active;
}
