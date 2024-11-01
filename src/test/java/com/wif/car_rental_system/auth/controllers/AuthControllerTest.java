package com.wif.car_rental_system.auth.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wif.car_rental_system.auth.domain.dtos.req.SigninReqDto;
import com.wif.car_rental_system.auth.services.AuthService;
import com.wif.car_rental_system.users.domain.entities.UserEntity;
import com.wif.car_rental_system.users.domain.enums.UserRoleEnum;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private AuthService userDetailsService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  private ObjectMapper objectMapper;

  private static final String TEST_EMAIL = "dzhu5@gmail.com";

  @BeforeEach
  void setUp() {
    this.objectMapper = new ObjectMapper();

    UserEntity userDetails = UserEntity.builder()
        .email(TEST_EMAIL)
        .password(passwordEncoder.encode("password"))
        .role(UserRoleEnum.ADMIN)
        .build();

    when(userDetailsService.loadUserByUsername(TEST_EMAIL))
        .thenReturn(userDetails);
  }

  @Test
  void whenAccessingPublicEndpoint_thenSuccess() throws Exception {
    String userJson = objectMapper.writeValueAsString(SigninReqDto.builder()
        .email(TEST_EMAIL)
        .password("password1232")
        .build());

    mockMvc.perform(post("/auth/signin")
        .contentType(MediaType.APPLICATION_JSON)
        .content(userJson))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.token").exists())
        .andExpect(jsonPath("$.token").isString());
  }

}
