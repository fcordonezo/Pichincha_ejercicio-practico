package com.pichincha.ejerciciobackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.pichincha.ejerciciobackend.model.Person;
import com.pichincha.ejerciciobackend.repository.PersonRepository;

@SpringBootTest
public class PersonServiceTest {

	@Mock
	private PersonRepository personRepository;
	
	@InjectMocks
	private PersonServiceImpl personService;
	
	private Person person;
	
	@BeforeEach
	void  setUp(){
		MockitoAnnotations.openMocks(this);
		person = new Person();
		person.setId(1);
		person.setAge(20);
		person.setFullName("FC");
		person.setPersonalId("1234");
		person.setAccounts(null);
	}
	
	@Test
	void getById() {
		when(personRepository.findById(1)).thenReturn(Optional.of(person));
		assertNotNull(personService.getById(1));
		assertEquals(personService.getById(1), person);
	}
	
	@Test
	void getAll() {
		List<Person> personList = new ArrayList<>();
		personList.add(person);
		when(personRepository.findAll()).thenReturn(personList);
		assertNotNull(personService.getAll());
	}
	
	@Test
	void getByPersonalId() {
		when(personRepository.findByPersonalId("1234")).thenReturn(Optional.of(person));
		assertNotNull(personService.getByPersonalId("1234"));
		assertEquals(personService.getByPersonalId("1234"), person);
	}
	
}
