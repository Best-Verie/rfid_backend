package com.rfid.rfid_backend.controller;

import com.rfid.rfid_backend.Exceptions.EnoughMoneyNotFoundException;
import com.rfid.rfid_backend.dto.TransactionDTO;
import com.rfid.rfid_backend.model.Card;
import com.rfid.rfid_backend.model.Transaction;
import com.rfid.rfid_backend.repository.CardRepository;
import com.rfid.rfid_backend.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public ResponseEntity<Transaction> create(@RequestBody TransactionDTO transactionDTO){
        String tagId = transactionDTO.getTagId();
        Optional<Card> cardFound = cardRepository.findByTagId(tagId);


        Integer transportFare = transactionDTO.getTransportFare();


        if(cardFound.isEmpty()){
            Card card = cardRepository.save(new Card(tagId, 500));

            if(transportFare > card.getBalance()){
                throw new EnoughMoneyNotFoundException("-- Balance not enough!");
            }

            Integer newBalanceToSave = card.getBalance() - transportFare;

            Transaction transaction = new Transaction();
            transaction.setCard(card);
            transaction.setTransportFare(transportFare);

            cardRepository.save(new Card(tagId,newBalanceToSave));
            return ResponseEntity.ok(transactionsRepository.save(transaction));

        }

        else {

            Integer currentBalance = cardFound.get().getBalance();

            if(transportFare > currentBalance){
                throw new EnoughMoneyNotFoundException("-- Balance not enough!");
            }

            Integer newBalanceToSave = currentBalance - transportFare;


            Transaction transaction = new Transaction();
            transaction.setCard(cardFound.get());
            transaction.setTransportFare(transportFare);

            Transaction saved = transactionsRepository.save(transaction);

            cardFound.get().setBalance(newBalanceToSave);
            cardRepository.save(cardFound.get());

            return ResponseEntity.ok(saved);

        }



    }

    @GetMapping("/api/transactions/getCardInfo/{cardId}")
    public Transaction getCardInfo(@PathVariable Card cardId){
        return transactionsRepository.findByCard(cardId);
    }

    @PostMapping("/api/transactions/{id}")
    public Optional<Transaction> findTransaction(@PathVariable Long id){
        return transactionsRepository.findById(id);
    }



}
