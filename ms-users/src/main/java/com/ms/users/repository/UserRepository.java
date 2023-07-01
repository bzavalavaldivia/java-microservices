package com.ms.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.users.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
