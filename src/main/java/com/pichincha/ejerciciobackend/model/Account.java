package com.pichincha.ejerciciobackend.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "Accounts")
public class Account {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "balance", precision = 2, nullable = false)
	private Float balance;
	
	@Column(name = "due_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dueDate;

	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_person", nullable = false)
	@JsonBackReference 
	private Person person;
	
	@OneToMany(mappedBy = "account", orphanRemoval = true)
	private List<Transaction> transactions;

	@Column(name = "type")
	private String type;

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
		
	}

	public Float getBalance() {
		return this.balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
		
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
}
