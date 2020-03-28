package com.lekha.jokha.controller;

import java.util.Map;

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

		Map<String, String> loginStatus = userService.loginUser(user);
		
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(userService.loginUser(user));
		}

		return ResponseEntity.status(Integer.valueOf(loginStatus.get("statusCode"))).body(loginStatus.get("statusMessage"));
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(path = "/user/signup")
	public ResponseEntity registerUser(@Valid @RequestBody User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(userService.registerUser(user));
		}

		return ResponseEntity.status(201).body(userService.registerUser(user));
	}
}
