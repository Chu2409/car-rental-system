package com.wif.car_rental_system.maintenance.domain.entities;

import java.time.LocalDateTime;

import com.wif.car_rental_system.maintenance.domain.enums.MaintenanceStatusEnum;
import com.wif.car_rental_system.maintenance.domain.enums.MaintenanceTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity(name = "maintenance")
public class MaintenanceEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, name = "start_date")
  private LocalDateTime startDate;

  @Column(nullable = false, name = "end_date")
  private LocalDateTime endDate;

  @Column
  private String description;

  @Column
  private Float cost;

  @Column(nullable = false)
  private MaintenanceStatusEnum status;

  @Column(nullable = false)
  private MaintenanceTypeEnum type;

}
