package com.pichincha.ejerciciobackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.pichincha.ejerciciobackend.model.Account;
import com.pichincha.ejerciciobackend.model.Transaction;
import com.pichincha.ejerciciobackend.repository.TransactionRepository;

@SpringBootTest
public class TransactionServiceTest {
	@Mock
	private TransactionRepository transactionRepository;
	
	@InjectMocks
	private TransactionServiceImpl transactionService;
	
	private Transaction transaction;
	
	@BeforeEach
	void  setUp(){
		MockitoAnnotations.openMocks(this);
		transaction = new Transaction();
		transaction.setId(1);
		transaction.setAmount(20f);
		transaction.setCreatedAt(new Date());
		transaction.setAccount(new Account());
	}
	
	@Test
	void getById() {
		when(transactionRepository.findById(1l)).thenReturn(Optional.of(transaction));
		assertNotNull(transactionService.getById(1l));
		assertEquals(transactionService.getById(1l), transaction);
	}
	
	@Test
	void getAll() {
		List<Transaction> transactionList = new ArrayList<>();
		transactionList.add(transaction);
		when(transactionRepository.findAll()).thenReturn(transactionList);
		assertNotNull(transactionService.getAll());
	}
}
