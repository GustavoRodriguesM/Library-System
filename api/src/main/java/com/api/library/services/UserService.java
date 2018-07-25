package com.api.library.services;

import com.api.library.models.User;

public interface UserService extends DefaultService<User, Long> {

	User findByEmail(String email);

	User findByToken(String token);
	
	Boolean checkEmailTaken(String email);
	
	void encodePasswordAndToken(User user);

}
