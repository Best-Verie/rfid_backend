package com.rfid.rfid_backend.repository;

import com.rfid.rfid_backend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionsRepository extends JpaRepository<Transaction, Integer> {
    Optional<Transaction> findById(Long id);

    Transaction findByTagId(String tagId);
}
