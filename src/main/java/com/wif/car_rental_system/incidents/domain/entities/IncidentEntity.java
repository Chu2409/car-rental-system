package com.wif.car_rental_system.incidents.domain.entities;

import java.time.LocalDateTime;

import com.wif.car_rental_system.incidents.domain.enums.IncidentStatusEnum;
import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;

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
@Entity(name = "incidents")
public class IncidentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 200)
  private String description;

  @Column(nullable = false)
  private Float repairCost;

  @Column(nullable = false)
  private LocalDateTime reportedAt;

  @Column
  private String photoEvidenceUrl;

  @Column(nullable = false, length = 20)
  private IncidentStatusEnum status;

  @ManyToOne(optional = false)
  @JoinColumn(referencedColumnName = "id", nullable = false)
  private RentalEntity rental;
}
