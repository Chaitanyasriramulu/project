package com.incident.service;

import java.util.List;

import com.incident.entity.User;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUsers();
	User getUserById(long id);
	User updateUser(User user, long id);
	void deleteUser(long id);

}
