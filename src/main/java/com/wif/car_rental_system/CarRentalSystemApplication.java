package com.wif.car_rental_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CarRentalSystemApplication {

  // @Override
  // protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
  //   return application.sources(CarRentalSystemApplication.class);
  // }

  public static void main(String[] args) {
    SpringApplication.run(CarRentalSystemApplication.class, args);
  }
}
