package com.example.demo.websocket;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MyMessage {

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String  message;
}
