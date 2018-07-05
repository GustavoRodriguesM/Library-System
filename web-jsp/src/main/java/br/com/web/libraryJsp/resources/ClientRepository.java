package br.com.web.libraryJsp.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.web.libraryJsp.models.Client;
import br.com.web.libraryJsp.models.User;

@RepositoryRestResource(path = "clients", collectionResourceRel = "clients")
public interface ClientRepository extends JpaRepository<Client, Long> {

	Client findByUser(User user);

}
