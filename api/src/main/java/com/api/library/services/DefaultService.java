package com.api.library.services;

import java.util.List;

public interface DefaultService<T, ID> {
	
	void save (T arg);
	
	void update(T arg);
	
	T findById(ID id);
	
	List<T> findAll();
	
	List<T> findAllWithTrashed();
	
	void disable(T arg);
	
	void enable(T arg);

}
