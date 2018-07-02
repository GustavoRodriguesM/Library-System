package br.com.web.libraryJsp.services;

import br.com.web.libraryJsp.models.User;

public interface UserService extends AbstractService<User, Long> {

	User findByEmail(String email);

	User findByToken(String token);

}
