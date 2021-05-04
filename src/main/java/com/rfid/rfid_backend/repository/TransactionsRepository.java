package com.rfid.rfid_backend.repository;

import com.rfid.rfid_backend.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
}
