package com.elifcan.product.repository;

import com.elifcan.product.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    // Searching according to Model
    List<Car> findAllByModel(String model);
    List<Car> findAllByModelLike(String model);

    // Searching according to year
    List<Car> findAllByYear(int year);
    List<Car> findAllByYearLessThan(int year);
    List<Car> findAllByYearGreaterThan(int year);

    // Searching according to fuelType
    List<Car> findAllByFuelType(Integer fuelType);

    // Searching according to isAvailable
    List<Car> findAllByIsAvailableTrue();
    List<Car> findAllByIsAvailableFalse();

    // Searching according to price
    List<Car> findAllByPriceBetween(double lower, double upper);

    // Searching according to model and fuelType
    List<Car> findAllByModelAndFuelType(String model, Integer fuelType);

    // Searching according to model not having a
    List<Car> findAllByModelNotContaining(String statement);
    List<Car> findAllByModelNotLike(String statement);

}
