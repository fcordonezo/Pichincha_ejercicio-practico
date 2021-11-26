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
import com.pichincha.ejerciciobackend.model.Person;
import com.pichincha.ejerciciobackend.repository.AccountRepository;

@SpringBootTest
public class AccountServiceTest {
	
	@Mock
	private AccountRepository accountRepository;
	
	@InjectMocks
	private AccountServiceImpl accountService;
	
	private Account account;
	
	@BeforeEach
	void  setUp(){
		MockitoAnnotations.openMocks(this);
		account = new Account();
		account.setId(1);
		account.setBalance(20f);
		account.setDueDate(new Date());
		account.setPerson(new Person());
		account.setType("Cuenta Ahorros");
		account.setTransactions(null);
	}
	
	@Test
	void getById() {
		when(accountRepository.findById(1)).thenReturn(Optional.of(account));
		assertNotNull(accountService.getById(1));
		assertEquals(accountService.getById(1), account);
	}
	
	@Test
	void getAll() {
		List<Account> accountList = new ArrayList<>();
		accountList.add(account);
		when(accountRepository.findAll()).thenReturn(accountList);
		assertNotNull(accountService.getAll());
	}
}
