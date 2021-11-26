package com.pichincha.ejerciciobackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.ejerciciobackend.model.Transaction;
import com.pichincha.ejerciciobackend.repository.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountService accountService;
	
	@Override
	public List<Transaction> getAll() {
		return transactionRepository.findAll();
	}

	@Override
	public Transaction getById(Long id) {
		return transactionRepository.findById(id).get();
	}

	@Override
	public void post(Transaction transaction) {
		Transaction newTransaction = transaction;
		newTransaction.setAccount(accountService.getById(transaction.getAccount().getId()));
		transactionRepository.save(newTransaction);
	}

	@Override
	public void delete(Long id) {
		transactionRepository.deleteById(id);
		
	}

}
