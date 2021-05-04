package com.rfid.rfid_backend.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity

public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;


    public void setId(Integer id) {
        this.id = id;
    }

    @javax.persistence.Id
    public Integer getId() {
        return id;
    }

    @NotNull
    public Integer card_uuid;

    @NotNull
    public Integer transaction_fare;

    @NotNull
    public Integer new_balance;
    public Transactions() {
    }

    public Transactions(Integer card_uuid, Integer transaction_fare, Integer new_balance) {
        this.card_uuid = card_uuid;
        this.transaction_fare = transaction_fare;
        this.new_balance = new_balance;
    }

    public Integer getCard_uuid() {
        return card_uuid;
    }

    public void setCard_uuid(Integer card_uuid) {
        this.card_uuid = card_uuid;
    }

    public Integer getTransaction_fare() {
        return transaction_fare;
    }

    public void setTransaction_fare(Integer transaction_fare) {
        this.transaction_fare = transaction_fare;
    }

    public Integer getNew_balance() {
        return new_balance;
    }

    public void setNew_balance(Integer new_balance) {
        this.new_balance = new_balance;
    }
}
