package com.rfid.rfid_backend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class EnoughMoneyNotFoundException extends RuntimeException{

    public EnoughMoneyNotFoundException(String message){
        super(message);

    }
}
