package com.rfid.rfid_backend.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity

public class Transaction {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)

    public Long id;


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }


    public String tagId;

    @NotNull

    public Integer transactionFare;

    @NotNull

    public Integer newBalance;

    public Transaction() {
    }


    public Transaction(Long id) {
        this.id = id;
    }


    public Transaction(String tagId, Integer transactionFare, Integer newBalance) {
        this.tagId = tagId;
        this.transactionFare = transactionFare;
        this.newBalance = newBalance;
    }

    public Transaction(Long id, String tagId, Integer transactionFare, Integer newBalance) {
        this.id = id;
        this.tagId = tagId;
        this.transactionFare = transactionFare;
        this.newBalance = newBalance;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public Integer getTransactionFare() {
        return transactionFare;
    }

    public void setTransactionFare(Integer transactionFare) {
        this.transactionFare = transactionFare;
    }

    public Integer setNewBalance() {
        return newBalance;
    }

    public void setNewBalance(Integer newBalance) {
        this.newBalance = newBalance;
    }
}
