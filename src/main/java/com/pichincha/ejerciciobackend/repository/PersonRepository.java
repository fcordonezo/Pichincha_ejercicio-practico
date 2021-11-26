package com.pichincha.ejerciciobackend.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.ejerciciobackend.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	Optional<Person> findByPersonalId(String personalId);
}
