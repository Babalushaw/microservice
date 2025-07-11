package com.microservice.user.payload;

import org.springframework.http.HttpStatus;
public class APIResponse {
    private String messages;
    private boolean success;
    private HttpStatus status;

    public APIResponse(String messages, boolean success, HttpStatus status) {
        this.messages = messages;
        this.success = success;
        this.status = status;
    }

    public APIResponse() {
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
