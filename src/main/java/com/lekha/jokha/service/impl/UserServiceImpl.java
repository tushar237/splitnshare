package com.lekha.jokha.service.impl;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
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
	public User loginUser(User user) {

		User loginUser = null;

		com.lekha.jokha.entities.User userEntity = new com.lekha.jokha.entities.User();

		userEntity.setEmail(user.getEmail());
		userEntity.setFullName(user.getFullName());
		userEntity.setPassword(user.getPassword());
		userEntity.setPhoneNo(user.getPhoneNo());

		try {
			Optional<com.lekha.jokha.entities.User> registeredUser = usersRepo.findById(userEntity.getEmail());
			if (null != registeredUser.get()
					&& user.getPassword().equalsIgnoreCase(registeredUser.get().getPassword())) {
				loginUser = new User();
				loginUser.setEmail(registeredUser.get().getEmail());
				loginUser.setFullName(StringUtils.capitalize(registeredUser.get().getFullName()));
				loginUser.setPhoneNo(registeredUser.get().getPhoneNo());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginUser;
	}

	@Override
	public User registerUser(User user) {

		User signUpUser = null;

		com.lekha.jokha.entities.User userEntity = new com.lekha.jokha.entities.User();
		userEntity.setEmail(user.getEmail());
		userEntity.setFullName(user.getFullName());
		userEntity.setPassword(user.getPassword());
		userEntity.setPhoneNo(user.getPhoneNo());

		try {
			com.lekha.jokha.entities.User registeredUser = usersRepo.save(userEntity);
			if (null != registeredUser) {
				signUpUser = new User();
				signUpUser.setEmail(registeredUser.getEmail());
				signUpUser.setFullName(StringUtils.capitalize(registeredUser.getFullName()));
				signUpUser.setPhoneNo(registeredUser.getPhoneNo());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return signUpUser;
	}

}
