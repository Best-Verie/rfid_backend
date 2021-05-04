package com.rfid.rfid_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

//@Table(name ="rfid_cards")

public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public void setId(int id) {
        this.id = id;
    }
    @javax.persistence.Id
    public int getId() {
        return id;
    }

    public String card_uuid;
    public String owner;
    public Integer current_balance;

}
