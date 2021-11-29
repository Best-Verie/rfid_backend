package com.rfid.rfid_backend.Service;

import com.rfid.rfid_backend.Exceptions.CardNotFoundException;
import com.rfid.rfid_backend.Utils.APIResponse;
import com.rfid.rfid_backend.model.Card;
import com.rfid.rfid_backend.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public List<Card> getAll(){
        return cardRepository.findAll();
    }

    public Optional<Card> getCardByTagId(String tagId){
        Optional<Card> cardFound = cardRepository.findByTagId(tagId);
        if(!cardFound.isEmpty()){
            throw new CardNotFoundException(" - card : " + tagId +" Not found!");
        }
        return cardFound;
    }

    public ResponseEntity<?> saveCard(Card card){
        Optional<Card> cardFound = cardRepository.findByTagId(card.getTagId());
        System.out.println(cardFound);

        if(cardFound.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse(false,"Card already in"));		}
        this.cardRepository.save(card);
        return ResponseEntity.ok(card);
    }
}
