package com.wif.car_rental_system.users.domain.entities;

import java.time.LocalDateTime;

import com.wif.car_rental_system.users.domain.enums.UserRoleEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "users")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 50)
  private String name;

  @Column(nullable = false, length = 50, name = "last_name")
  private String lastName;

  @Column(nullable = false, length = 255, unique = true)
  private String email;

  @Column(nullable = false, length = 255)
  private String password;

  @Column(length = 15)
  private String phone;

  @Column(length = 255)
  private String address;

  @Column(length = 20, nullable = false, name = "role")
  private UserRoleEnum role;

  @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Column(name = "active", nullable = false, columnDefinition = "boolean default true")
  @Default
  private Boolean active = true;

}
