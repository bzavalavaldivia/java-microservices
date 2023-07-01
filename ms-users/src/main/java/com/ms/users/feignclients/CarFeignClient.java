package com.ms.users.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ms.users.models.Car;

@FeignClient(name = "ms-cars", url = "http://localhost:8002")
@RequestMapping("/api/cars")
public interface CarFeignClient {
	@PostMapping
	public Car create(@RequestBody Car car);
	
	@GetMapping("/user/{userId}")
	public List<Car> getAll(@PathVariable("userId") Long userId);
}
