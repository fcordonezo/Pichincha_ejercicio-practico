package com.pichincha.ejerciciobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.ejerciciobackend.model.Transaction;
import com.pichincha.ejerciciobackend.service.TransactionService;

@RestController
@RequestMapping("transactions")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping
	public List<Transaction> getAll(){
		return transactionService.getAll();
	}
	
	@GetMapping("/{id}")
	public Transaction getById(@PathVariable("id") Long id) {
		return transactionService.getById(id);
	}
	
	@PostMapping
	public void post(@RequestBody Transaction transaction) {
		transactionService.post(transaction);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		transactionService.delete(id);
	}
}
