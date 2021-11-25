package com.pichincha.ejerciciobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pichincha.ejerciciobackend.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
