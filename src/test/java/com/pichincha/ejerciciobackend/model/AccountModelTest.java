package com.pichincha.ejerciciobackend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountModelTest {
	
	Account account; 
	@BeforeEach
	public void setUp() {
		account = new Account();
		account.setBalance(10f);
		account.setDueDate(new Date());
		account.setId(1);
		account.setPerson(new Person());
		account.setType("Cuenta Ahorros");
		account.setTransactions(null);
	}
	
	@Test
	public void getId() {
		assertEquals(account.getId(), 1);
	}
	
	@Test
	public void getType() {
		assertEquals(account.getType(), "Cuenta Ahorros");
	}
}
