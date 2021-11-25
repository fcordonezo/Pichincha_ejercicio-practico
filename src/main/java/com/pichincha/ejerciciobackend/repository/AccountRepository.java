package com.pichincha.ejerciciobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pichincha.ejerciciobackend.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
