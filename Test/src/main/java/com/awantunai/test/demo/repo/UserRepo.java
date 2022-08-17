package com.awantunai.test.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awantunai.test.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findByEmail(String email);
}
