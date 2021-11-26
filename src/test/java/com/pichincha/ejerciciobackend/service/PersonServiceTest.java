package com.pichincha.ejerciciobackend.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.assertj.core.util.Arrays;
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
	private PersonService personService;
	
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
	void getAllById(Integer id) {
		when(personRepository.findById(id));
		assertNotNull(personService.getAll());
	}
}
