package com.rfid.rfid_backend.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @NotNull
    public String tagId;

    @NotNull
    public Integer transportFare;

    @NotNull
    public Integer newBalance;

    @CreationTimestamp
    public LocalDateTime transactionDateTime;

    public Transaction() {
    }


    public Transaction(Long id) {
        this.id = id;
    }


    public Transaction(String tagId, Integer transportFare, Integer newBalance) {
        this.tagId = tagId;
        this.transportFare = transportFare;
        this.newBalance = newBalance;
    }

    public Transaction(Long id, String tagId, Integer transportFare, Integer newBalance,LocalDateTime transactionDateTime) {
        this.id = id;
        this.tagId = tagId;
        this.transportFare = transportFare;
        this.newBalance = newBalance;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }


    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public Integer getTransportFare() {
        return transportFare;
    }

    public void setTransportFare(Integer transportFare) {
        this.transportFare = transportFare;
    }

    public Integer setNewBalance() {
        return newBalance;
    }

    public void setNewBalance(Integer newBalance) {
        this.newBalance = newBalance;
    }
}
