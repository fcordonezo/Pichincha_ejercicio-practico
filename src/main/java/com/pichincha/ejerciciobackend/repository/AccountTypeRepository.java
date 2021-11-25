package com.pichincha.ejerciciobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pichincha.ejerciciobackend.model.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {

}
