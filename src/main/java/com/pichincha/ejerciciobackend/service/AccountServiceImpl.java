package com.pichincha.ejerciciobackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.ejerciciobackend.commons.AccountUtils;
import com.pichincha.ejerciciobackend.model.Account;
import com.pichincha.ejerciciobackend.model.Person;
import com.pichincha.ejerciciobackend.model.Transaction;
import com.pichincha.ejerciciobackend.repository.AccountRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	PersonService personService;
	
	@Override
	public List<Account> getAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account getById(Integer id) {
		return accountRepository.findById(id).get();
	}

	@Override
	public void post(Account account) {
		Account newAccount = account;
		newAccount.setDueDate(AccountUtils.setDueDate());
		if(newAccount.getBalance() == null) {
			newAccount.setBalance(0f);
		}
		newAccount.setPerson(personService
			.getByPersonalId(account.getPerson().getPersonalId()));
		
		accountRepository.save(newAccount);
		
	}

	@Override
	public void put(Integer id, Account account) {
		Account newAccount = account;
		newAccount.setId(id);
		accountRepository.findById(id).map(accountIterator -> {
			if(!(newAccount.getDueDate() == null)) {
				accountIterator.setDueDate(newAccount.getDueDate());
			}
			if(!(newAccount.getType() == null)) {
				accountIterator.setType(newAccount.getType());		
			}
			if(!(newAccount.getBalance() == null)) {
				accountIterator.setBalance(newAccount.getBalance());
			}
			if(!(newAccount.getPerson() == null)) {
				accountIterator.setPerson(personService
						.getByPersonalId(newAccount.getPerson().getPersonalId()));
			}
			return accountRepository.save(accountIterator);
		});
	}
	
	
	@Override
	public void delete(Integer id) {
		Account account = accountRepository.getById(id);
		Person person = account.getPerson();
		person.getAccounts().remove(person.getAccounts().indexOf(account));
		accountRepository.deleteById(id);
	}

	@Override
	public List<Transaction> getTransactionsFromDateToDate(Integer id) {
		return accountRepository.findById(id).get().getTransactions();
	}

}
