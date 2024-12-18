package com.wif.car_rental_system.payments.domain.dtos;

import java.time.LocalDateTime;

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
public class PaymentResDto {
  private Long id;
  private Float amount;
  private LocalDateTime paymentDate;
  private String type;
  private String status;

}