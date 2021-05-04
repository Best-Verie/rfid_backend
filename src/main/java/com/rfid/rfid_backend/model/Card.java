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
    public String card_uuid;

    @NotNull
    public String owner;

    @NotNull
    public Integer current_balance;


    protected Card(){}

    public Card(String card_uuid, String owner, Integer current_balance) {
        this.card_uuid = card_uuid;
        this.owner = owner;
        this.current_balance = current_balance;
    }


    public String getCard_uuid() {
        return card_uuid;
    }

    public void setCard_uuid(String card_uuid) {
        this.card_uuid = card_uuid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(Integer current_balance) {
        this.current_balance = current_balance;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
