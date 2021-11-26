package com.pichincha.ejerciciobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.ejerciciobackend.model.Account;
import com.pichincha.ejerciciobackend.model.Person;
import com.pichincha.ejerciciobackend.service.PersonService;

@RestController
@RequestMapping("people")
public class PersonController {
	@Autowired
	PersonService personService;
	
	@GetMapping
	public List<Person> getAll(){
		return personService.getAll();
	}
	
	@GetMapping("/{id}")
	public Person getByPersonalId(@PathVariable("id") Integer id) {
		return personService.getById(id);
	}
	
	@GetMapping("/{id}/accounts")
	public List<Account> getAccounts(@PathVariable("id") Integer id){
		return personService.getById(id).getAccounts();
	}
	
	@PostMapping
	public void post(@RequestBody Person person) {
		personService.post(person);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		personService.delete(id);
	}
}
