package com.awantunai.test.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.awantunai.test.demo.entity.User;
import com.awantunai.test.demo.repo.UserRepo;
import com.awantunai.test.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public User registerUser(User user) {
		String enCodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(enCodedPassword);
		return userRepo.save(user);
	}

	@Override
	public String login(String email, String password) {
		User user = userRepo.findByEmail(email);
		if(user != null) {
			if(password.equalsIgnoreCase(user.getPassword())) {
				return "Login success ";
			} else {
				return " email and password combination are not matching ! ";
			}
			
		} else {
			return "User not found ! ";
		}
	}

}
