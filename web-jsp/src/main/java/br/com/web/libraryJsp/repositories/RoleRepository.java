package br.com.web.libraryJsp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.web.libraryJsp.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>	{

}
