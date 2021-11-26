package com.pichincha.ejerciciobackend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransactionModelTest {
	
	Transaction transaction;
	
	@BeforeEach
	public void setUp() {
		transaction = new Transaction();
		transaction.setAccount(null);
		transaction.setAmount(10f);
		transaction.setCreatedAt(new Date());
		transaction.setId(1l);
	}
	
	@Test
	public void getId() {
		assertEquals(transaction.getId(), 1l);
	}
	
	@Test
	public void getType() {
		assertEquals(transaction.getAmount(), 10f);
	}
}
