package br.com.web.libraryJsp.resources;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.web.libraryJsp.models.User;

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

	List<User> findByDeletedAt(Calendar deletedAt);

	User findByToken(String token);
}
