package com.incident.service;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.incident.entity.User;
import com.incident.exception.ResourceNotFoundException;
import com.incident.repository.UserRepo;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@Override
	public User getUserById(long id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new ResourceNotFoundException("User", "id", id);
		}
	}
	@Override
	public User updateUser(User user, long id) {
		
		Optional<User> existingUser = userRepo.findById(id);
		if (!existingUser.isPresent()) {
			throw new ResourceNotFoundException("User", "id", id);
		}
		
		User updateUser = existingUser.get();
		//updateInc.setSummary(incident.getSummary() == null ? updateInc.getSummary() : incident.getSummary());
		updateUser.setUsername(user.getUsername());
		updateUser.setPassword(user.getPassword());
		
		userRepo.save(updateUser);
		
		return updateUser;
	}
	@Override
	public void deleteUser(long id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			userRepo.deleteById(id);
		} else {
			throw new ResourceNotFoundException("User", "id", id);
		}
		
	}
}
