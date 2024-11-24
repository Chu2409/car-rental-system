package com.wif.car_rental_system.rates.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wif.car_rental_system.rates.domain.entities.RateEntity;

public interface RateRepository extends JpaRepository<RateEntity, Long> {

}
