package com.wif.car_rental_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:${user.dir}/.env")
public class CarRentalSystemApplication {

  public static void main(String[] args) {
    SpringApplication.run(CarRentalSystemApplication.class, args);
  }

}
