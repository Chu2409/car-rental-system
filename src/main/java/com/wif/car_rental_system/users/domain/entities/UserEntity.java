package com.wif.car_rental_system.users.domain.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;
import com.wif.car_rental_system.users.domain.enums.UserRoleEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

  @Column(nullable = false, length = 50)
  private String lastName;

  @Column(nullable = false, length = 255, unique = true)
  private String email;

  @Column(nullable = false, length = 255)
  private String password;

  @Column(length = 15)
  private String phone;

  @Column(length = 255)
  private String address;

  @Column(length = 20, nullable = false)
  private UserRoleEnum role;

  @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Column(nullable = false, columnDefinition = "boolean default true")
  @Default
  private Boolean active = true;

  @OneToMany(mappedBy = "user")
  @Default
  private List<RentalEntity> userRentals = new ArrayList<>();

  @OneToMany(mappedBy = "employee")
  @Default
  private List<RentalEntity> employeeRentals = new ArrayList<>();

}
