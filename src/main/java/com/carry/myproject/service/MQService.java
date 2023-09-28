package com.carry.myproject.service;

public interface MQService {
    void sendMessage(String exchange, String routingKey, Object message);
}
