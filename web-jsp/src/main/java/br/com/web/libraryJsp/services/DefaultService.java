package br.com.web.libraryJsp.services;

import java.util.List;

public interface DefaultService<T, ID> {
	
	T save (T arg);
	
	T update(T arg);
	
	T findById(ID id);
	
	List<T> findAll();
	
	List<T> findAllWithTrashed();
	
	void disable(T arg);
	
	void enable(T arg);

}
