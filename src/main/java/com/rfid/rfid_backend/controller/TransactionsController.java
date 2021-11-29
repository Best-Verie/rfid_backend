package com.rfid.rfid_backend.controller;

import com.rfid.rfid_backend.Exceptions.EnoughMoneyNotFoundException;
import com.rfid.rfid_backend.Service.TransactionService;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TransactionsController {
    @Autowired
    private TransactionService transactionService;


    @GetMapping("/api/transactions")
    public List<Transaction> getAll(){
        return transactionService.getAll();
    }

    @PostMapping("/api/transactions")
    public ResponseEntity<Transaction> create(@RequestBody TransactionDTO transactionDTO){
        return transactionService.recordTransaction(transactionDTO);
    }

    @GetMapping("/api/transactions/getCardInfo/{cardId}")
    public Transaction getCardInfo(@PathVariable Card cardId){
        return transactionService.getTransactionByCard(cardId);
    }

//    @PostMapping("/api/transactions/{id}")
//    public Optional<Transaction> findTransaction(@PathVariable Long id){
//        return transactionsRepository.findById(id);
//    }



}
