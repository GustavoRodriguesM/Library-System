package com.api.library.services.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.library.models.User;
import com.api.library.resources.UserRepository;
import com.api.library.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(User user) {
		user.setCreatedAt(Calendar.getInstance());
		user.setUpdatedAt(Calendar.getInstance());
		
	}

	@Override
	public void update(User user) {
		user.setUpdatedAt(Calendar.getInstance());
	}

	@Override
	public User findById(Long id) {
		return this.userRepository.getOne(id);
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findByDeletedAt(null);
	}

	@Override
	public List<User> findAllWithTrashed() {
		return this.userRepository.findAll();
	}

	@Override
	public void disable(User user) {
		user.setDeletedAt(Calendar.getInstance());
		this.update(user);
	}

	@Override
	public void enable(User user) {
		user.setDeletedAt(null);
		this.update(user);
	}

	@Override
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	@Override
	public User findByToken(String token) {
		return this.userRepository.findByToken(token);
	}

}