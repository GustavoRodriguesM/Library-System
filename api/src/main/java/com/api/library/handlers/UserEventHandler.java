package com.api.library.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.api.library.models.User;
import com.api.library.services.UserService;

@ServiceHandler
@RepositoryEventHandler(User.class)
public class UserEventHandler {

	@Autowired
	private UserService userService;

	@HandleBeforeCreate
	public void handleBeforeCreates(User user) {
		try {
			this.userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@HandleBeforeSave
	public void handleBeforeSave(User user) {
		System.out.println("Testing save handler");
	}

}
