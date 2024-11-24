package com.wif.car_rental_system.payments.domain.mappers;

import org.springframework.stereotype.Component;

import com.wif.car_rental_system.payments.domain.dtos.CreatePaymentReqDto;
import com.wif.car_rental_system.payments.domain.dtos.PaymentResDto;
import com.wif.car_rental_system.payments.domain.dtos.UpdatePaymentReqDto;
import com.wif.car_rental_system.payments.domain.entities.PaymentEntity;
import com.wif.car_rental_system.payments.domain.enums.PaymentStatusEnum;
import com.wif.car_rental_system.payments.domain.enums.PaymentTypeEnum;
import com.wif.car_rental_system.rentals.domain.entities.RentalEntity;

@Component
public class PaymentMapper {

  public PaymentEntity toEntity(Long id) {
    return PaymentEntity.builder()
        .id(id)
        .build();
  }

  public PaymentEntity toEntity(CreatePaymentReqDto dto) {
    PaymentStatusEnum status = PaymentStatusEnum.of(dto.getStatus());
    PaymentTypeEnum type = PaymentTypeEnum.of(dto.getType());
    RentalEntity rental = RentalEntity.builder().id(dto.getRentalId()).build();

    return PaymentEntity.builder()
        .amount(dto.getAmount())
        .paymentDate(dto.getPaymentDate())
        .status(status)
        .type(type)
        .rental(rental)
        .build();
  }

  public PaymentEntity toEntity(UpdatePaymentReqDto dto) {
    PaymentStatusEnum status = PaymentStatusEnum.of(dto.getStatus());
    PaymentTypeEnum type = PaymentTypeEnum.of(dto.getType());
    RentalEntity rental = dto.getRentalId() != null ? RentalEntity.builder().id(dto.getRentalId()).build() : null;

    return PaymentEntity.builder()
        .amount(dto.getAmount())
        .paymentDate(dto.getPaymentDate())
        .status(status)
        .type(type)
        .rental(rental)
        .build();
  }

  public PaymentResDto toRes(PaymentEntity entity) {

    return PaymentResDto.builder()
        .id(entity.getId())
        .amount(entity.getAmount())
        .paymentDate(entity.getPaymentDate())
        .status(entity.getStatus().getLabel())
        .type(entity.getType().getLabel())
        .build();
  }
}
