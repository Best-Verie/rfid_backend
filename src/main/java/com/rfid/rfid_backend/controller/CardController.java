package com.rfid.rfid_backend.controller;

import com.rfid.rfid_backend.model.Card;
import com.rfid.rfid_backend.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/Cards")
public class CardController {
    @Autowired
    private CardRepository cardRepository;

    @GetMapping
    public List<Card> getAll(){
        return cardRepository.findAll();
    }
    
}
