package com.wif.car_rental_system.payments.domain.dtos;

import java.time.LocalDateTime;

import com.wif.car_rental_system.payments.domain.enums.PaymentStatusEnum;
import com.wif.car_rental_system.payments.domain.enums.PaymentTypeEnum;
import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FullPaymentResDto {
  private Long id;
  private Float amount;
  private LocalDateTime paymentDate;
  private PaymentTypeEnum type;
  private PaymentStatusEnum status;
  private RentalEntity rental;

}
