package com.rfid.rfid_backend.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;



//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
@Entity
public class Card {
     //I wanna generate it using uuid class
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    public String tagId = UUID.randomUUID().toString();

    @NotNull
    public String owner;

    @NotNull
    public Integer currentBalance;

    protected Card(){}

    public Card(String tagId) {
        this.tagId = tagId;
    }

    public Card(String owner, Integer currentBalance) {
        this.owner = owner;
        this.currentBalance = currentBalance;
    }

    public Card(String tagId, String owner, Integer currentBalance) {
        this.tagId = tagId;
        this.owner = owner;
        this.currentBalance = currentBalance;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Integer currentBalance) {
        this.currentBalance = currentBalance;
    }

}
