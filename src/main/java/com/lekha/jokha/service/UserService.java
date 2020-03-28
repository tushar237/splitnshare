package com.lekha.jokha.service;

import java.util.Map;

import com.lekha.jokha.businessobj.User;

public interface UserService {

	public Map<String, String> registerUser(User user);

	public Map<String, String> loginUser(User user);
}
