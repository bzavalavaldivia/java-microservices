package com.ms.cars.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.cars.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	@Autowired
	List<Car> findByUserId(Long userId);
}
