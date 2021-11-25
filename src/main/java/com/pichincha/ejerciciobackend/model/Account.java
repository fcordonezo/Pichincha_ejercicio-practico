package com.pichincha.ejerciciobackend.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "Accounts")
public class Account {

	@Id
	@Getter
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Getter @Setter
	@Column(
		name = "balance", 
		precision = 2
	)
	private float balance;
	
	@Column(name = "due_date")
	private Date dueDate;
	
	@Getter @Setter
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_person")
	private Person person;
	
	@Getter @Setter
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_account_type")
	private AccountType accountType;
	
	
	
}
