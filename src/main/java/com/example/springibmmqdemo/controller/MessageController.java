package com.example.springibmmqdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springibmmqdemo.service.MQService;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MQService mqService;

    @PostMapping
    public String sendMessage(@RequestBody String message) {
        mqService.sendMessage("DEV.QUEUE.1", message);
        return "Message sent: " + message;
    }
}