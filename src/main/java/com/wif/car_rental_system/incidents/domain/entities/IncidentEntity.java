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
  private long id;

  @Column(nullable = false, length = 200)
  private String description;

  @Column(nullable = false, name = "repair_cost")
  private Float repairCost;

  @Column(nullable = false, name = "reported_at")
  private LocalDateTime reportedAt;

  @Column(name = "photo_evidence")
  private String photoEvidence;

  @Column(nullable = false, length = 20)
  private IncidentStatusEnum status;

  @ManyToOne(optional = false, targetEntity = RentalEntity.class)
  @JoinColumn(name = "rental_id", referencedColumnName = "id")
  private RentalEntity rental;
}
