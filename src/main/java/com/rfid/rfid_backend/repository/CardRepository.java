package com.rfid.rfid_backend.repository;

import com.rfid.rfid_backend.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository <Card , Integer> {
}
