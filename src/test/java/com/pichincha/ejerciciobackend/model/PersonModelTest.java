package com.pichincha.ejerciciobackend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonModelTest {

	private Person person;
	@BeforeEach
	public void setUp() {
		person = new Person();
		person.setId(1);
		person.setAge(20);
		person.setFullName("FC");
		person.setPersonalId("1234");
		person.setAccounts(null);
	}
	
	@Test
	public void getPersonalId() {
		assertEquals(person.getPersonalId(), "1234");
	}
	
	@Test
	public void getId() {
		assertEquals(person.getId(), 1);
	}
}
