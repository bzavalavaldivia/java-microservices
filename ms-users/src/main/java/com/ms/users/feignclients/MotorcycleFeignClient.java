package com.ms.users.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ms.users.models.Motorcycle;

@FeignClient(name = "ms-motorcycles", url = "http://localhost:8003")
@RequestMapping("/api/motorcycles")
public interface MotorcycleFeignClient {
	@PostMapping
	public Motorcycle create(@RequestBody Motorcycle motorcycle);
	
	@GetMapping("/user/{userId}")
	public List<Motorcycle> getAll(@PathVariable("userId") Long userId);
}
