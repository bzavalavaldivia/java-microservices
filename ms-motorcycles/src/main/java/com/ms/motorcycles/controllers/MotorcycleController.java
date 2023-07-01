package com.ms.motorcycles.controllers;

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

import com.ms.motorcycles.entities.Motorcycle;
import com.ms.motorcycles.services.MotorcycleService;

@RestController
@RequestMapping("/api/motorcycles")
public class MotorcycleController {
	@Autowired
	private MotorcycleService motorcycleService;
	
	@GetMapping
	public ResponseEntity<List<Motorcycle>> getAll() {
		List<Motorcycle> motorcycles = motorcycleService.getAll();
		if (motorcycles.isEmpty()) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(motorcycles);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Motorcycle> getOne(@PathVariable("id") Long id) {
		Motorcycle motorcycle = motorcycleService.getOne(id);
		if (motorcycle == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(motorcycle);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<Motorcycle> create(@RequestBody Motorcycle user) {
		return ResponseEntity.ok(motorcycleService.create(user));
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Motorcycle>> getAllByUser(@PathVariable("userId") Long userId) {
		List<Motorcycle> motorcycles = motorcycleService.getAllByUser(userId);
		if (motorcycles.isEmpty()) return ResponseEntity.noContent().build();
		return ResponseEntity.ok(motorcycles);
	}
}
