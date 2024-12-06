package com.wif.car_rental_system.payments.domain.entities;

import java.time.LocalDateTime;

import com.wif.car_rental_system.payments.domain.enums.PaymentStatusEnum;
import com.wif.car_rental_system.payments.domain.enums.PaymentTypeEnum;
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
@Entity(name = "payments")
public class PaymentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Float amount;

  @Column(nullable = false)
  private LocalDateTime paymentDate;

  @Column(length = 20)
  private PaymentTypeEnum type;

  @Column(nullable = false, length = 20)
  private PaymentStatusEnum status;

  @ManyToOne(optional = false)
  @JoinColumn(nullable = false, referencedColumnName = "id")
  private RentalEntity rental;
}
