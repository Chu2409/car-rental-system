package com.wif.car_rental_system.cars.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.wif.car_rental_system.cars.domain.dtos.CarResDto;
import com.wif.car_rental_system.cars.domain.entities.CarEntity;
import com.wif.car_rental_system.cars.domain.mappers.CarMapper;
import com.wif.car_rental_system.cars.services.CarService;

@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CarService carService;

  @MockBean
  private CarMapper mapper;

  @Test
  void whenFindById_thenReturnCar() throws Exception {
    CarEntity carEntity = CarEntity.builder()
        .id(1L)
        .brand("Toyota")
        .model("Corolla")
        .year(2023)
        .build();

    CarResDto carResDto = CarResDto.builder()
        .id(1L)
        .brand("Toyota")
        .model("Corolla")
        .year(2023)
        .build();

    when(carService.findById(1L)).thenReturn(carEntity);
    when(mapper.toRes(carEntity)).thenReturn(carResDto);

    mockMvc.perform(get("/cars/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.brand").value("Toyota"))
        .andExpect(jsonPath("$.model").value("Corolla"))
        .andExpect(jsonPath("$.year").value(2023));
  }
}
