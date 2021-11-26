package com.pichincha.ejerciciobackend.service;

import java.util.List;

import com.pichincha.ejerciciobackend.model.Transaction;

public interface TransactionService {

	List<Transaction> getAll();
	
	Transaction getById(Long id);
	
	void post(Transaction transaction);
	
	void delete(Long id);
	
}
