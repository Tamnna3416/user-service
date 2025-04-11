package com.sarvika.demo.service;

import java.util.List;

import com.sarvika.demo.model.User;

public interface UserService {
	User saveUser(User user);

	List<User> getAllUsers();

	User getUserById(Long id);

	void deleteUser(Long id);
}
