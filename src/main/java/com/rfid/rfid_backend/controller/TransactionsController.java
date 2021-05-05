package com.rfid.rfid_backend.controller;

import com.rfid.rfid_backend.Exceptions.EnoughMoneyNotFoundException;
import com.rfid.rfid_backend.model.Card;
import com.rfid.rfid_backend.model.Transaction;
import com.rfid.rfid_backend.repository.CardRepository;
import com.rfid.rfid_backend.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionsController {
    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private CardRepository cardRepository;

    @GetMapping("/api/transactions")
    public List<Transaction> getAll(){
        return transactionsRepository.findAll();
    }

    @PostMapping("/api/transactions")
    public ResponseEntity<?> create(@RequestBody Transaction transaction){
        String tagId = transaction.getTagId();
        Optional<Card> cardFound = cardRepository.findByTagId(tagId);

        Integer transportFare = transaction.getTransportFare();

        Integer currentBalance = cardFound.get().getCurrentBalance();

        if(transportFare>currentBalance){
            throw new EnoughMoneyNotFoundException("-- Balance not enough!");
        }

        Integer newBalanceToSave = currentBalance - transportFare;
        transactionsRepository.save(new Transaction(tagId,transportFare,newBalanceToSave));


        cardFound.get().setCurrentBalance(newBalanceToSave);
        cardRepository.save(cardFound.get());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/transactions/getCardInfo/{tagId}")
    public Transaction getCardInfo(@PathVariable String tagId){
        return transactionsRepository.findByTagId(tagId);
    }

    @PostMapping("/api/transactions/{id}")
    public Optional<Transaction> findTransaction(@PathVariable Long id){
        return transactionsRepository.findById(id);
    }



}
