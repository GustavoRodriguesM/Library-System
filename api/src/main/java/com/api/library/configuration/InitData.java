package com.api.library.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.api.library.models.Role;
import com.api.library.models.User;
import com.api.library.resources.RoleRepository;
import com.api.library.resources.UserRepository;
import com.api.library.services.UserService;

@Component
public class InitData implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private RoleRepository roleService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		if (roleService.findAll().isEmpty()) {
			Role roleUser = new Role("ROLE_USER");
			Role roleAdmin = new Role("ROLE_ADMIN");

			List<Role> roles = new ArrayList<>();
			roles.add(roleUser);
			roles.add(roleAdmin);
			
			this.roleService.save(roleUser);
			this.roleService.save(roleAdmin);
			this.roleService.save(new Role("ROLE_CLIENT"));

			User user = new User();
			user.setName("Admin");
			user.setEmail("admin@library.com");
			user.setPassword("1234567");
			user.setPasswordConfirmation("1234567");
			user.setRoles(roles);

			this.userService.save(user);
			this.userRepository.save(user);
		}
	}
}
