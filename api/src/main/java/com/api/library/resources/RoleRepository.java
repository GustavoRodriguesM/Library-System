package com.api.library.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.api.library.models.Role;

@RepositoryRestResource(path = "roles", collectionResourceRel = "content")
public interface RoleRepository extends JpaRepository<Role, String>	{

}
