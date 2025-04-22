package com.example.springibmmqdemo.listener;

import org.springframework.jms.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @JmsListener(destination = "DEV.QUEUE.1")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
