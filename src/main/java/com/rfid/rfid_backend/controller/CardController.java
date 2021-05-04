package com.rfid.rfid_backend.controller;

import com.rfid.rfid_backend.model.Card;
import com.rfid.rfid_backend.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
//
//    @PostMapping("/api/cards");
//    public List<Card> search(@RequestBody Map<String, String> body){
//        String searchTerm = body.get("text");
//        return cardRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
//    }

}
