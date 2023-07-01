package com.ms.users.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.users.entities.User;
import com.ms.users.feignclients.CarFeignClient;
import com.ms.users.feignclients.MotorcycleFeignClient;
import com.ms.users.models.Car;
import com.ms.users.models.Motorcycle;
import com.ms.users.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private CarFeignClient carFeignClient;
	
	@Autowired
	private MotorcycleFeignClient motorcycleFeignClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User>getAll() {
		return userRepository.findAll();
	}
	
	public  User getOne(Long id) {
		return userRepository.findById(id).get();
	}
	
	public User create(User user) {
		return userRepository.save(user);
	}
	
	public Car createCar(Long userId, Car car) {
		car.setUserId(userId);
		return carFeignClient.create(car);
	}
	
	@SuppressWarnings("unchecked")
	public List<Car> getAllCars(Long userId) {
		List<Car> cars = restTemplate.getForObject("http://localhost:8002/api/cars/user/" + userId, List.class);
		return cars;
	}
	
	public Motorcycle createMotorcycle(Long userId, Motorcycle motorcycle) {
		motorcycle.setUserId(userId);
		return motorcycleFeignClient.create(motorcycle);
	}
	
	@SuppressWarnings("unchecked")
	public List<Motorcycle> getAllMotorcycles(Long userId) {
		List<Motorcycle> motorcycles = restTemplate.getForObject("http://localhost:8003/api/motorcycles/user/" + userId, List.class);
		return motorcycles;
	}
	
	public Map<String, Object> getVehicles(Long userId) {
		Map<String, Object> result = new HashMap<>();
		User user = userRepository.findById(userId).get();
		if (user == null) {
			result.put("message", "User not found.");
			return result;
		}
		result.put("user", user);
		
		List<Car> cars = carFeignClient.getAll(userId);
		if (cars.isEmpty()) {
			result.put("cars", "User doesnt have cars.");
		} else {
			result.put("cars", cars);
		}
		
		List<Motorcycle> motorcycles = motorcycleFeignClient.getAll(userId);
		if (motorcycles.isEmpty()) {
			result.put("motorcycles", "User doesnt have motorcycles.");
		} else {
			result.put("motorcycles", motorcycles);
		}
		
		return result;
	}
}
