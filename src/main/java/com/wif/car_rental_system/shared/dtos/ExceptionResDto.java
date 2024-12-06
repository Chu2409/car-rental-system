package com.wif.car_rental_system.shared.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResDto {
  private String message;
  private String path;
}
