package com.pichincha.ejerciciobackend.service;

import java.util.List;

import com.pichincha.ejerciciobackend.model.Account;
import com.pichincha.ejerciciobackend.model.Transaction;

public interface AccountService {
	
	List<Account> getAll();
	
	Account getById(Integer id);
	
	void post(Account account);
	
	void put(Integer id, Account account);
	
	void delete(Integer id);
	
	List<Transaction> getTransactionsFromDateToDate(Integer id);
}
