package com.rfid.rfid_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public Integer card_uuid;
    public Integer transaction_fare;
    public Integer new_balance;

}
