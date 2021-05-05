package com.rfid.rfid_backend.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @NotNull
    public Long tagId;

    @NotNull
    public Integer transactionFare;

    @NotNull
    public Integer newBalance;
    public Transactions() {
    }

    public Transactions(Long id) {
        this.id = id;
    }

    public Transactions(Long tagId, Integer transactionFare, Integer newBalance) {
        this.tagId = tagId;
        this.transactionFare = transactionFare;
        this.newBalance = newBalance;
    }

    public Transactions(Long id, Long tagId, Integer transactionFare, Integer newBalance) {
        this.id = id;
        this.tagId = tagId;
        this.transactionFare = transactionFare;
        this.newBalance = newBalance;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
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
