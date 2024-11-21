package com.wif.car_rental_system.maintenance.domain.entities;

import java.time.LocalDateTime;

import com.wif.car_rental_system.cars.domain.entities.CarEntity;
import com.wif.car_rental_system.maintenance.domain.enums.MaintenanceStatusEnum;
import com.wif.car_rental_system.maintenance.domain.enums.MaintenanceTypeEnum;

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
@Entity(name = "maintenance")
public class MaintenanceEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime startDate;

  @Column(nullable = false)
  private LocalDateTime endDate;

  @Column
  private String description;

  @Column(nullable = false)
  private Float cost;

  @Column(nullable = false, length = 20)
  private MaintenanceStatusEnum status;

  @Column(nullable = false, length = 20)
  private MaintenanceTypeEnum type;

  @ManyToOne(optional = false)
  @JoinColumn(nullable = false, referencedColumnName = "id")
  private CarEntity car;

}
