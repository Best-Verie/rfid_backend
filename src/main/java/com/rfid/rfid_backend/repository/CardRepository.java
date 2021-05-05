package com.rfid.rfid_backend.repository;

import com.rfid.rfid_backend.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository <Card , String> {
    Optional<Card> findByTagId(String tagId);

    Optional<Card> deleteByTagId(String tagId);
//    List<Card> findCardByOwner(String owner);

//    Integer getCurrentBalance(String tagId);

//    Card updateCardBalance(String tagId);
}
