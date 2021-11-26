package com.pichincha.ejerciciobackend.service;

import java.util.List;

import com.pichincha.ejerciciobackend.model.Person;

public interface PersonService {
	
	Person getById(Integer id);
	
	Person getByPersonalId(String personalId);
	
	List<Person> getAll();
	
	void post(Person person);
	
	void delete(Integer id);
}
