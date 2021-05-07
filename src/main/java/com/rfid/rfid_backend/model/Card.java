package com.rfid.rfid_backend.model;

import com.sun.istack.NotNull;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @NotNull
    public String tagId;

    @NotNull
    public Integer balance;

    public Card() {
    }

    public Card(Long id) {
        this.id = id;
    }

    public Card(String tagId, Integer balance) {
        this.tagId = tagId;
        this.balance = balance;
    }

    public Card(Long id, String tagId, Integer balance) {
        this.id = id;
        this.tagId = tagId;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
