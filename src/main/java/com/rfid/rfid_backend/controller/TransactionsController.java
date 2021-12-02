package com.rfid.rfid_backend.controller;

import com.rfid.rfid_backend.Services.TransactionService;
import com.rfid.rfid_backend.dto.TransactionDTO;
import com.rfid.rfid_backend.model.Card;
import com.rfid.rfid_backend.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
