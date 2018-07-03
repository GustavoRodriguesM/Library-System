package br.com.web.libraryJsp.services;

import br.com.web.libraryJsp.models.User;

public interface UserService extends DefaultService<User, Long> {

	User findByEmail(String email);

	User findByToken(String token);

}
