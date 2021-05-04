package com.rfid.rfid_backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Card {
    @Id
    public String card_id;
    public void setId(String id) {
        this.card_id = id;
    }
    @javax.persistence.Id
    public String getId() {
        return card_id;
    }

    public String owner;
    public Integer current_balance;

}
