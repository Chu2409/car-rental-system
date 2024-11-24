package com.wif.car_rental_system.users.domain.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResDto {
  private Long id;
  private String name;
  private String lastName;
  private String email;
  private String phone;
  private String address;
  private String role;
  private LocalDateTime createdAt;
  private Boolean active;

}
