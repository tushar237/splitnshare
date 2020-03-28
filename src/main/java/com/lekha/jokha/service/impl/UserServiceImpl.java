package com.lekha.jokha.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lekha.jokha.businessobj.User;
import com.lekha.jokha.repo.UsersRepo;
import com.lekha.jokha.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UsersRepo usersRepo;

	@Override
	public Map<String, String> loginUser(User user) {

		com.lekha.jokha.entities.User userEntity = new com.lekha.jokha.entities.User();

		userEntity.setEmail(user.getEmail());
		userEntity.setFullName(user.getFullName());
		userEntity.setPassword(user.getPassword());
		userEntity.setPhoneNo(user.getPhoneNo());

		Map<String, String> response = new HashMap<String, String>();
		String statusMessage = "";
		String statusCode = "";

		try {
			Optional<com.lekha.jokha.entities.User> registeredUser = usersRepo.findById(userEntity.getEmail());
			if (null != registeredUser.get() && user.getPassword().equalsIgnoreCase(registeredUser.get().getPassword())) {
				statusMessage = "Login successful for User: " + registeredUser.get().getFullName().toUpperCase();
				statusCode = "200";
			} else {
				statusMessage = "Login Failed. Invalid Login credentials. Try Again.";
				statusCode = "401";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.put("statusCode", statusCode);
		response.put("statusMessage", statusMessage);
		return response;
	}

	@Override
	public Map<String, String> registerUser(User user) {

		com.lekha.jokha.entities.User userEntity = new com.lekha.jokha.entities.User();
		userEntity.setEmail(user.getEmail());
		userEntity.setFullName(user.getFullName());
		userEntity.setPassword(user.getPassword());
		userEntity.setPhoneNo(user.getPhoneNo());

		Map<String, String> response = new HashMap<String, String>();
		String statusMessage = "";
		String statusCode = "";
		
		try {
			com.lekha.jokha.entities.User registeredUser = usersRepo.save(userEntity);
			if (null != registeredUser) {
				statusMessage = "Registration is successful for User: " + registeredUser.getFullName();
				statusCode = "201";
			} else {
				statusMessage = "Registartion Failed";
				statusCode = "422";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.put("statusCode", statusCode);
		response.put("statusMessage", statusMessage);

		return response;
	}

}
