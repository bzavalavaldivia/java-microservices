package com.ms.cars.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.cars.entities.Car;
import com.ms.cars.repository.CarRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository cartRepository;
	
	public List<Car>getAll() {
		return cartRepository.findAll();
	}
	
	public  Car getOne(Long id) {
		return cartRepository.findById(id).get();
	}
	
	public Car create(Car cart) {
		return cartRepository.save(cart);
	}
	
	public List<Car> getAllByUser(Long userId) {
		return cartRepository.findByUserId(userId);
	}
}
