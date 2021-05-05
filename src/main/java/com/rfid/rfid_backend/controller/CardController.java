package com.rfid.rfid_backend.controller;

import com.rfid.rfid_backend.Exceptions.CardNotFoundException;
import com.rfid.rfid_backend.model.Card;
import com.rfid.rfid_backend.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Map;
import java.util.Optional;
//import javax.validation.Valid;


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
    public Card create(@RequestBody Card card){
        return cardRepository.save(card);
    }

    @PostMapping("/api/cards/updateCard/{tagId}")
    public Card updateCard(@PathVariable String tagId, @RequestBody Card cardToUpdate){
        Optional<Card> cardFound = cardRepository.findByTagId(tagId);

        if(!cardFound.isPresent())
            throw new CardNotFoundException(" -- card no : "+tagId);

        cardToUpdate.setTagId(cardFound.get().getTagId());

        return cardRepository.save(cardToUpdate);
    }

    @GetMapping("/api/cards/checkCard/{tagId}")
    public Optional<Card> getCardByTagId(@PathVariable String tagId){
        Optional<Card> cardFound = cardRepository.findByTagId(tagId);
        if(!cardFound.isEmpty()){
            throw new CardNotFoundException(" - card : " + tagId +" Not found!");
        }
        return cardFound;
    }

    @DeleteMapping("/api/cards/deleteCard/{id}")
    public boolean deleteExistingCard(@PathVariable String tagId){
        Optional<Card> cardFound = cardRepository.findByTagId(tagId);

        if(!cardFound.isPresent())
            throw new CardNotFoundException(" -- card  : "+tagId);
        cardRepository.deleteByTagId(tagId);
        return true;
    }




}
