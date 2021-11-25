package com.pichincha.ejerciciobackend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity (name = "People")
public class Person {

	@Id
	@Getter
	@Column(name = "id")
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;

	@Getter @Setter
	@Column(name = "age", nullable = false)
	private int age;
	
	@Getter @Setter
	@Column(name = "DNI", nullable = false)
	private String dni;
	
	@Getter @Setter
	@Column(name = "full_name", nullable = false)
	private String fullName;
	
	@Getter @Setter
	@OneToMany(mappedBy = "person")
	private List<Account> accounts;
	
}
