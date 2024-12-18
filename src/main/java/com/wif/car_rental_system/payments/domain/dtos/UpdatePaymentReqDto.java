package com.wif.car_rental_system.payments.domain.dtos;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wif.car_rental_system.payments.domain.enums.PaymentStatusEnum;
import com.wif.car_rental_system.payments.domain.enums.PaymentTypeEnum;
import com.wif.car_rental_system.shared.validators.EnumValue;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePaymentReqDto {
  @PositiveOrZero(message = "amount must be positive or zero")
  private Float amount;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @JsonFormat(pattern = "dd/MM/yyyy':'HH:mm")
  private LocalDateTime paymentDate;

  @EnumValue(enumClass = PaymentStatusEnum.class, message = "status must be one of the types")
  private String status;

  @EnumValue(enumClass = PaymentTypeEnum.class, message = "type must be one of the types")
  private String type;

  @PositiveOrZero(message = "rentalId must be positive or zero")
  private Long rentalId;

}