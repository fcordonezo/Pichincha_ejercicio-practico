package com.pichincha.ejerciciobackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

@Entity(name = "Account_types")
public class AccountType {

	@Id
	@Getter
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	
}
