package com.wif.car_rental_system.users.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/users")
public class UserController {

  @Value("${JWT_TIMEZONE_OFFSET}")
  private String appName;

  @PostMapping
  public String getMethodName() {
    return appName;
  }

}
