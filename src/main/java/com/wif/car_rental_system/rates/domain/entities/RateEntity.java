package com.wif.car_rental_system.rates.domain.entities;

import java.time.LocalDateTime;

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
@Entity(name = "rates ")
public class RateEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, length = 100)
  private String vehicleType;

  @Column(nullable = false, name = "base_rate")
  private Float baseRate;

  @Column(nullable = false, name = "peak_rate")
  private Float peakRate;

  @Column(nullable = false, name = "start_date")
  private LocalDateTime startDate;

  @Column(nullable = false, name = "end_date")
  private LocalDateTime endDate;

  @Column(name = "active", nullable = false, columnDefinition = "boolean default true")
  @Default
  private boolean active = true;
}
