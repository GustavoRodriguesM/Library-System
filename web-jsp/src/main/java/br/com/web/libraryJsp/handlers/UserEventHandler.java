package br.com.web.libraryJsp.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import br.com.web.libraryJsp.models.User;
import br.com.web.libraryJsp.services.UserService;

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
