package com.pichincha.ejerciciobackend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity (name = "People")
public class Person {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "personal_id", nullable = false, unique = true)
	private String personalId;

	@Column(name = "full_name", nullable = false)
	private String fullName;

	@Column(name = "age", length = 3)
	private int age;
	
	@OneToMany(mappedBy = "person", orphanRemoval = true)
	private List<Account> accounts;


	public List<Account> getAccounts() {
		return this.accounts;
	}


	public String getPersonalId() {
		return this.personalId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}


	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
}
