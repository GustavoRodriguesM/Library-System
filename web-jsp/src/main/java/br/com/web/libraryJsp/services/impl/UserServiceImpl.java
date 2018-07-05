package br.com.web.libraryJsp.services.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.web.libraryJsp.models.User;
import br.com.web.libraryJsp.resources.UserRepository;
import br.com.web.libraryJsp.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		user.setCreatedAt(Calendar.getInstance());
		user.setUpdatedAt(Calendar.getInstance());
		
		return this.userRepository.save(user);
	}

	@Override
	public User update(User user) {
		user.setUpdatedAt(Calendar.getInstance());
		
		return this.userRepository.save(user);
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
