package com.example.springibmmqdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final JmsTemplate jmsTemplate;

    @PostMapping
    public String sendMessage(@RequestBody String message) {
        jmsTemplate.convertAndSend("DEV.QUEUE.1", message);
        return "Message sent: " + message;
    }
}
