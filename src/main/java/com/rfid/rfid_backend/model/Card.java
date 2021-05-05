package com.rfid.rfid_backend.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
//import javax.validation.Valid;



//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
@Entity
public class Card {
     //I wanna generate it using uuid class
    @Id
    public String tagId = UUID.randomUUID().toString();

    @NotNull
    public String owner;

    @NotNull
//    @Min(0)
    public Integer currentBalance;

    @CreationTimestamp
    private Date createdOn;

    protected Card(){}

    public Card(String tagId) {
        this.tagId = tagId;
    }

    public Card(String owner, Integer currentBalance) {
        this.owner = owner;
        this.currentBalance = currentBalance;
    }

    public Card(String tagId, String owner, Integer currentBalance, Date createdOn) {
        this.tagId = tagId;
        this.owner = owner;
        this.currentBalance = currentBalance;
        this.createdOn = createdOn;
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


    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
