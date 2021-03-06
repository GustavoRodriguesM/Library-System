package com.api.library.configuration;

import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.api.library.projections.BookWithAuthors;

@Configuration
public class RepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config
			.exposeIdsFor(entityManager.getMetamodel().getEntities()
			.stream().map(e -> e.getJavaType())
				.collect(Collectors.toList()).toArray(new Class[0]));
		
		config
			.getProjectionConfiguration()
			.addProjection(BookWithAuthors.class);
	}
	
}