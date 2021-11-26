package com.pichincha.ejerciciobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.ejerciciobackend.model.Account;
import com.pichincha.ejerciciobackend.model.Transaction;
import com.pichincha.ejerciciobackend.service.AccountService;

@RestController
@RequestMapping("accounts")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping
	public List<Account> getAll(){
		return accountService.getAll();
	}
	
	@GetMapping("/{id}")
	public Account getById(@PathVariable("id") Integer id) {
		return accountService.getById(id);
	}
	
	@GetMapping("/{id}/transactions/")
	public List<Transaction> getTransactionsFromDateToDate(@PathVariable("id") Integer id){
		return accountService.getTransactionsFromDateToDate(id);
	}
	
	@PostMapping()
	public void post(@RequestBody Account account) {
		accountService.post(account);
	}
	
	@PutMapping("/{id}")
	public void put(@PathVariable("id") Integer id, @RequestBody Account account) {
		accountService.put(id, account);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		accountService.delete(id);
	}
}
