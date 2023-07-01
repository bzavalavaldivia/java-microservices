package com.ms.cars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ms.cars.entities.Car;
import com.ms.cars.services.CarService;

@RestController
@RequestMapping("/api/cars")
public class CarController {
	@Autowired
	private CarService cartService;
	
	@GetMapping
	public ResponseEntity<List<Car>> getAll() {
		List<Car> cars = cartService.getAll();
		if (cars.isEmpty()) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(cars);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Car> getOne(@PathVariable("id") Long id) {
		Car car = cartService.getOne(id);
		if (car == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(car);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<Car> create(@RequestBody Car user) {
		return ResponseEntity.ok(cartService.create(user));
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Car>> getAllByUser(@PathVariable("userId") Long userId) {
		List<Car> cars = cartService.getAllByUser(userId);
		if (cars.isEmpty()) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(cars);
	}
}
