package br.com.web.libraryJsp.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.web.libraryJsp.models.User;
import br.com.web.libraryJsp.resources.UserRepository;


@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);

		if (user == null) 
			throw new UsernameNotFoundException("User " + username + " can't be found!");
		

		return new LibraryUserDetails(user);

	}

}
