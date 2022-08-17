package com.awantunai.test.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.awantunai.test.demo.entity.User;
import com.awantunai.test.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.registerUser(user), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public String loginUser(@RequestParam String email, @RequestParam String password) {
		String message = userService.login(email, password);
		return message;
	}
}
