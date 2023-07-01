package com.ms.users.controllers;

import java.util.List;
import java.util.Map;

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

import com.ms.users.entities.User;
import com.ms.users.models.Car;
import com.ms.users.models.Motorcycle;
import com.ms.users.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		List<User> users = userService.getAll();
		if (users.isEmpty()) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getOne(@PathVariable("id") Long id) {
		User user = userService.getOne(id);
		if (user == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(user);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user) {
		return ResponseEntity.ok(userService.create(user));
	}
	
	@PostMapping("/{userId}/cars")
	public ResponseEntity<Car> createCar(@PathVariable("userId") Long userId, @RequestBody Car car) {
		return ResponseEntity.ok(userService.createCar(userId, car));
	}
	
	@GetMapping("/{userId}/cars")
	public ResponseEntity<List<Car>> getAllCars(@PathVariable("userId") Long userId) {
		List<Car> cars = userService.getAllCars(userId);
		if (cars.isEmpty()) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(cars);
	}
	
	@PostMapping("/{userId}/motorcycles")
	public ResponseEntity<Motorcycle> createMotorcycle(@PathVariable("userId") Long userId, @RequestBody Motorcycle motorcycle) {
		return ResponseEntity.ok(userService.createMotorcycle(userId, motorcycle));
	}
	
	@GetMapping("/{userId}/motorcycles")
	public ResponseEntity<List<Motorcycle>> getAllMotorcycles(@PathVariable("userId") Long userId) {
		List<Motorcycle> motorcycles = userService.getAllMotorcycles(userId);
		if (motorcycles.isEmpty()) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(motorcycles);
	}
	
	@GetMapping("/{userId}/vehicles")
	public ResponseEntity<Map<String, Object>> getVehicles(@PathVariable("userId") Long userId) {
		return ResponseEntity.ok(userService.getVehicles(userId));
	}
}
