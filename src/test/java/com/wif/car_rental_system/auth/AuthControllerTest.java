package com.wif.car_rental_system.auth;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wif.car_rental_system.auth.domain.dtos.req.SigninReqDto;
import com.wif.car_rental_system.auth.domain.dtos.res.SigninResDto;
import com.wif.car_rental_system.auth.domain.mappers.AuthMapper;
import com.wif.car_rental_system.auth.services.AuthService;
import com.wif.car_rental_system.auth.utils.JwtTokenUtil;
import com.wif.car_rental_system.users.domain.entities.UserEntity;
import com.wif.car_rental_system.users.domain.mappers.UserMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private AuthService service;

  @MockBean
  private JwtTokenUtil jwtTokenUtil;

  @MockBean
  private AuthenticationManager authenticationManager;

  @MockBean
  private AuthMapper mapper;

  @MockBean
  private UserMapper userMapper;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void testSignin() throws Exception {
    SigninReqDto signinDto = new SigninReqDto("email@gmail.com", "password");
    SigninResDto signinResDto = new SigninResDto("jwtToken");
    UserEntity userEntity = UserEntity.builder().email("email@gmail.com").password("password").build();
    var authToken = new UsernamePasswordAuthenticationToken(userEntity, null);

    when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authToken);
    when(jwtTokenUtil.genAccessToken(userEntity)).thenReturn("jwtToken");
    when(mapper.toRes("jwtToken")).thenReturn(signinResDto);
    when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
        .thenThrow(new Exception("Recurso no encontrado"));
    mockMvc.perform(post("/api/auth/signin")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(signinDto)))
        .andExpect(status().isOk());
    // .andExpect(jsonPath("$.campoDelDtoRespuesta").value("valorEsperado"));
  }
}
