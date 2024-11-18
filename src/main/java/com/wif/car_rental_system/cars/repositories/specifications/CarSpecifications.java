package com.wif.car_rental_system.cars.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.wif.car_rental_system.cars.domain.dtos.CarFilters;
import com.wif.car_rental_system.cars.domain.entities.CarEntity;

public class CarSpecifications {
    public static Specification<CarEntity> withFilters(CarFilters filters) {
        return (root, query, criteriaBuilder) -> {
            var predicates = criteriaBuilder.conjunction();

            if (filters.getSearch() != null && !filters.getSearch().isEmpty()) {
                var searchLower = "%" + filters.getSearch().toLowerCase() + "%";
                var searchPredicate = criteriaBuilder.or(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("brand")), searchLower),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("model")), searchLower));
                predicates = criteriaBuilder.and(predicates, searchPredicate);
            }

            if (filters.getType() != null) {
                predicates = criteriaBuilder.and(
                        predicates,
                        criteriaBuilder.equal(root.get("type"), filters.getType()));
            }

            if (filters.getStatus() != null) {
                predicates = criteriaBuilder.and(
                        predicates,
                        criteriaBuilder.equal(root.get("status"), filters.getStatus()));
            }

            if (filters.getYear() != null) {
                predicates = criteriaBuilder.and(predicates,
                        criteriaBuilder.equal(root.get("year"), filters.getYear()));
            }

            if (filters.getBrand() != null && !filters.getBrand().isEmpty()) {
                predicates = criteriaBuilder.and(predicates,
                        criteriaBuilder.like(root.get("brand"), "%" + filters.getBrand() + "%"));
            }

            if (filters.getMinPrice() != null) {
                predicates = criteriaBuilder.and(predicates,
                        criteriaBuilder.greaterThanOrEqualTo(root.get("dailyRate"), filters.getMinPrice()));
            }

            if (filters.getMaxPrice() != null) {
                predicates = criteriaBuilder.and(predicates,
                        criteriaBuilder.lessThanOrEqualTo(root.get("dailyRate"), filters.getMaxPrice()));
            }

            if (filters.getOrderBy() != null && !filters.getOrderBy().isEmpty()) {
                switch (filters.getOrderBy()) {
                    case "price_asc" -> query.orderBy(criteriaBuilder.asc(root.get("dailyRate")));
                    case "price_desc" -> query.orderBy(criteriaBuilder.desc(root.get("dailyRate")));
                    case "year_asc" -> query.orderBy(criteriaBuilder.asc(root.get("year")));
                    case "year_desc" -> query.orderBy(criteriaBuilder.desc(root.get("year")));
                }
            } else {
                query.orderBy(criteriaBuilder.asc(root.get("id")));
            }

            return predicates;
        };
    }
}