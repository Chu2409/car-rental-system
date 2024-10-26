package com.wif.car_rental_system.rates.domain.entities;

import java.time.LocalDateTime;

import com.wif.car_rental_system.cars.domain.enums.CarTypeEnum;

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
@Entity(name = "rates")
public class RateEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private CarTypeEnum carType;

  @Column(nullable = false)
  private Float baseRate;

  @Column(nullable = false)
  private Float peakRate;

  @Column(nullable = false)
  private LocalDateTime startDate;

  @Column(nullable = false)
  private LocalDateTime endDate;

  @Column(nullable = false, columnDefinition = "boolean default true")
  @Default
  private Boolean active = true;
}
