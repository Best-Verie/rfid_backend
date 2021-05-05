package com.rfid.rfid_backend.controller;

import com.rfid.rfid_backend.model.Card;
import com.rfid.rfid_backend.model.Transactions;
import com.rfid.rfid_backend.repository.CardRepository;
import com.rfid.rfid_backend.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/transactions")
public class TransactionsController {
    @Autowired
    private TransactionsRepository transactionsRepository;

    @GetMapping("/api/transactions")
    public List<Transactions> getAll(){
        return transactionsRepository.findAll();
    }

    @PostMapping("/api/transactions")
    public ResponseEntity<?> create(@RequestBody Transactions transactions){
        transactionsRepository.save(transactions);
        return (ResponseEntity<?>) ResponseEntity.ok().build();
    }
//
//    @PostMapping("/api/transactions/{id}")
//    public ResponseEntity<?> findTransaction(@PathVariable Long id){
//        transactionsRepository.findById(Math.toIntExact(id));
//        return (ResponseEntity<?>) ResponseEntity.ok().build();
//    }
}
