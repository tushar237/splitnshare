package com.lekha.jokha.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lekha.jokha.businessobj.User;
import com.lekha.jokha.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@SuppressWarnings("rawtypes")
	@PostMapping(path = "/user/login")
	public ResponseEntity loginUser(@Valid @RequestBody User user, BindingResult bindingResult) {

		User loginUser = userService.loginUser(user);
		
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(loginUser);
		}
		
		if(loginUser != null) {
			return ResponseEntity.status(Integer.valueOf(200)).body(loginUser);
		} else {
			return ResponseEntity.status(Integer.valueOf(401)).body(loginUser);
		}
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(path = "/user/signup")
	public ResponseEntity registerUser(@Valid @RequestBody User user, BindingResult bindingResult) {

		User signUpUser = userService.registerUser(user);
		
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(signUpUser);
		}
		
		if(signUpUser != null) {
			return ResponseEntity.status(Integer.valueOf(201)).body(signUpUser);
		} else {
			return ResponseEntity.status(Integer.valueOf(500)).body(signUpUser);
		}

	}
}
