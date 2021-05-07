package com.rfid.rfid_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDTO {
    private String tagId;
    private Integer transportFare;
}
