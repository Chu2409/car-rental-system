package com.wif.car_rental_system.rentals.domain.entities;

import java.time.LocalDateTime;
import com.wif.car_rental_system.cars.domain.entities.CarEntity;
import com.wif.car_rental_system.rentals.domain.enums.RentalStatusEnum;
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

  @Column(nullable = false)
  private LocalDateTime startDate;

  @Column(nullable = false)
  private LocalDateTime endDate;

  @Column
  private LocalDateTime actualEndDate;

  @Column
  private Float total;

  @Column(nullable = false, length = 20)
  private RentalStatusEnum status;

  @ManyToOne(optional = false)
  @JoinColumn(nullable = false, referencedColumnName = "id")
  private UserEntity user;

  @ManyToOne(optional = false)
  @JoinColumn(nullable = false, referencedColumnName = "id")
  private UserEntity employee;

  @ManyToOne(optional = false)
  @JoinColumn(nullable = false, referencedColumnName = "id")
  private CarEntity car;

  // @OneToMany(mappedBy = "rental", fetch = FetchType.LAZY)
  // @Default
  // private List<PaymentEntity> payments = new ArrayList<>();

  // @OneToMany(mappedBy = "rental", fetch = FetchType.LAZY)
  // @Default
  // private List<IncidentEntity> incidents = new ArrayList<>();

}
