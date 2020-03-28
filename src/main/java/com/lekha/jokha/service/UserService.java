package com.lekha.jokha.service;

import com.lekha.jokha.businessobj.User;

public interface UserService {

	public User registerUser(User user);

	public User loginUser(User user);
}
