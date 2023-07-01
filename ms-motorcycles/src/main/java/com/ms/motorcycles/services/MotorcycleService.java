package com.ms.motorcycles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.motorcycles.entities.Motorcycle;
import com.ms.motorcycles.repository.MotorcycleRepository;

@Service
public class MotorcycleService {
	@Autowired
	private MotorcycleRepository motorcycleRepository;
	
	public List<Motorcycle>getAll() {
		return motorcycleRepository.findAll();
	}
	
	public  Motorcycle getOne(Long id) {
		return motorcycleRepository.findById(id).get();
	}
	
	public Motorcycle create(Motorcycle cart) {
		return motorcycleRepository.save(cart);
	}
	
	public List<Motorcycle> getAllByUser(Long userId) {
		return motorcycleRepository.findByUserId(userId);
	}
}
