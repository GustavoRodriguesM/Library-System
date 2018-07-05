package br.com.web.libraryJsp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.web.libraryJsp.models.Client;
import br.com.web.libraryJsp.models.User;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	Client findByUser(User user);

}
