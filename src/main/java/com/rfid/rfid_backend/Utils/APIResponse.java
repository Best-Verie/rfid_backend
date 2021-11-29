package com.rfid.rfid_backend.Utils;

public class APIResponse {
    private boolean status;
    private String message;

    public APIResponse() {
        super();
    }

    public APIResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
