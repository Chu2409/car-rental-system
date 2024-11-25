package com.wif.car_rental_system.rentals.domain.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.wif.car_rental_system.cars.domain.dtos.CarResDto;
import com.wif.car_rental_system.incidents.domain.dtos.IncidentResDto;
import com.wif.car_rental_system.payments.domain.dtos.PaymentResDto;
import com.wif.car_rental_system.users.domain.dtos.UserResDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder.Default;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalResDto {
  private Long id;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private LocalDateTime actualEndDate;
  private Float total;
  private String status;
  private UserResDto user;
  private UserResDto employee;
  private CarResDto car;
  @Default
  private List<PaymentResDto> payments = new ArrayList<>();
  @Default
  private List<IncidentResDto> incidents = new ArrayList<>();

}
