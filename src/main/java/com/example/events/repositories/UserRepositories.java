package com.example.events.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.example.events.models.User;

public interface UserRepositories extends JpaRepository<User, Integer> {
	public User findByEmail(String email);
}
