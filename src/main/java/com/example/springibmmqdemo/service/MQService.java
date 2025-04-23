package com.example.springibmmqdemo.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

@Service
public class MQService {

  @Autowired
  private JmsTemplate jmsTemplate;

  @JmsListener(destination = "DEV.QUEUE.1")
  public void receiveMessage(String message) {
    System.out.println("Received message in service: " + message);
  }

  public void sendMessage(String destinationQueue, String message) {
    System.out.println("Sending message from service: " + message + " to queue " + destinationQueue);
    jmsTemplate.convertAndSend(destinationQueue, message);
  }
}