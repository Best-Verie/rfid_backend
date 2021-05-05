package com.rfid.rfid_backend.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @NotNull
    public Long tagId;

    @NotNull
    public String owner;

    @NotNull
    public Integer currentBalance;

    protected Card(){}

    public Card(Long id) {
        this.id = id;
    }

    public Card(Long tagId, String owner, Integer currentBalance) {
        this.tagId = tagId;
        this.owner = owner;
        this.currentBalance = currentBalance;
    }

    public Card(Long id, Long tagId, String owner, Integer currentBalance) {
        this.id = id;
        this.tagId = tagId;
        this.owner = owner;
        this.currentBalance = currentBalance;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
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


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
