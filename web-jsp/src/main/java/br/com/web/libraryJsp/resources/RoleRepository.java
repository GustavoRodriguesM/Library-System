package br.com.web.libraryJsp.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.web.libraryJsp.models.Role;

@RepositoryRestResource(path = "roles", collectionResourceRel = "roles")
public interface RoleRepository extends JpaRepository<Role, String>	{

}
