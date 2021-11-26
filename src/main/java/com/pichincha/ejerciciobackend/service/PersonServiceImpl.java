package com.pichincha.ejerciciobackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.ejerciciobackend.model.Person;
import com.pichincha.ejerciciobackend.repository.PersonRepository;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;
	
	@Override
	public Person getById(Integer id) {
		return personRepository.findById(id).get();
	}

	@Override
	public Person getByPersonalId(String personalId) {
		return personRepository.findByPersonalId(personalId).get();
	}
	
	@Override
	public List<Person> getAll() {
		return personRepository.findAll();
	}

	@Override
	public void post(Person person) {
		personRepository.save(person);
		
	}
	

	@Override
	public void delete(Integer id) {
		personRepository.deleteById(id);
	}

}
