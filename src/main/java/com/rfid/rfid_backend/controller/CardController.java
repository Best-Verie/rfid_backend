package com.rfid.rfid_backend.controller;

import com.rfid.rfid_backend.model.Card;
import com.rfid.rfid_backend.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Map;


@RestController
//@RequestMapping("/api/Cards")
public class CardController {
    @Autowired
    private CardRepository cardRepository;

    @GetMapping("/api/cards")
    public List<Card> getAll(){
        return cardRepository.findAll();
    }
    @PostMapping("/api/cards")
    public ResponseEntity<?> create(@RequestBody Card card){
       cardRepository.save(card);
       return (ResponseEntity<?>) ResponseEntity.ok();
    }


}
