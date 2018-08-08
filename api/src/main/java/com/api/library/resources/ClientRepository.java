package com.api.library.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.api.library.models.Client;
import com.api.library.models.User;

@RepositoryRestResource(path = "clients", collectionResourceRel = "content")
public interface ClientRepository extends JpaRepository<Client, Long> {

	Client findByUser(User user);

}
