package com.rfid.rfid_backend.controller;

import com.rfid.rfid_backend.Exceptions.CardNotFoundException;
import com.rfid.rfid_backend.Exceptions.EnoughMoneyNotFoundException;
import com.rfid.rfid_backend.Service.CardService;
import com.rfid.rfid_backend.model.Card;
import com.rfid.rfid_backend.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/api/cards")
    public List<Card> getAll(){
        return cardService.getAll();
    }

    @PostMapping("/api/cards")
    public ResponseEntity<?> create(@RequestBody Card card){
        return cardService.saveCard(card);
    }

    @GetMapping("/api/cards/checkCard/{tagId}")
    public Optional<Card> getCardByTagId(@PathVariable String tagId){
        return cardService.getCardByTagId(tagId);
    }

}
