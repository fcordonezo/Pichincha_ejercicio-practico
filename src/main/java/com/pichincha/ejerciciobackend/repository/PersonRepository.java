package com.pichincha.ejerciciobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pichincha.ejerciciobackend.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
