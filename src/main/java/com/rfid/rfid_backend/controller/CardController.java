package com.rfid.rfid_backend.controller;

import com.rfid.rfid_backend.Exceptions.CardNotFoundException;
import com.rfid.rfid_backend.Exceptions.EnoughMoneyNotFoundException;
import com.rfid.rfid_backend.model.Card;
import com.rfid.rfid_backend.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CardController {
    @Autowired
    private CardRepository cardRepository;

    @GetMapping("/api/cards")
    public List<Card> getAll(){
        return cardRepository.findAll();
    }

    @PostMapping("/api/cards")
    public Card create(@RequestBody Card card){
        return cardRepository.save(card);
    }
    @GetMapping("/api/cards/checkCard/{tagId}")
    public Optional<Card> getCardByTagId(@PathVariable String tagId){
        Optional<Card> cardFound = cardRepository.findByTagId(tagId);
        if(!cardFound.isEmpty()){
            throw new CardNotFoundException(" - card : " + tagId +" Not found!");
        }
        return cardFound;
    }

}
