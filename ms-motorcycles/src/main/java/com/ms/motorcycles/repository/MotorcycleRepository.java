package com.ms.motorcycles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.motorcycles.entities.Motorcycle;

@Repository
public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {
	List<Motorcycle> findByUserId(Long userId);
}
