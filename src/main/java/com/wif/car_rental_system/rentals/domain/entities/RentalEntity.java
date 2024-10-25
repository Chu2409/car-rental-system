package com.wif.car_rental_system.rentals.domain.entities;

import java.time.LocalDateTime;

import com.wif.car_rental_system.cars.domain.entities.CarEntity;
import com.wif.car_rental_system.cars.domain.enums.CarStatusEnum;
import com.wif.car_rental_system.users.domain.entities.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "rentals")
public class RentalEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "start_date")
  private LocalDateTime startDate;

  @Column(nullable = false, name = "end_date")
  private LocalDateTime endDate;

  @Column(name = "actual_end_date")
  private LocalDateTime actualEndDate;

  @Column()
  private Float total;

  @Column(nullable = false, length = 20)
  private CarStatusEnum status;

  @ManyToOne(optional = false, targetEntity = UserEntity.class)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserEntity user;

  @ManyToOne(optional = false, targetEntity = UserEntity.class)
  @JoinColumn(name = "employee_id", referencedColumnName = "id")
  private UserEntity employee;

  @ManyToOne(optional = false, targetEntity = CarEntity.class)
  @JoinColumn(name = "car_id", referencedColumnName = "id")
  private CarEntity car;

}
