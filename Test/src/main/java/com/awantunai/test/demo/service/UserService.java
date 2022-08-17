package com.awantunai.test.demo.service;

import com.awantunai.test.demo.entity.User;

public interface UserService {
	
	public User registerUser(User user);
	
	public String login(String email, String password);
}
