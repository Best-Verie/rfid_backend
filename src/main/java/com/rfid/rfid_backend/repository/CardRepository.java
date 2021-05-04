package com.rfid.rfid_backend.repository;

import com.rfid.rfid_backend.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository <Card , Long> {
}
