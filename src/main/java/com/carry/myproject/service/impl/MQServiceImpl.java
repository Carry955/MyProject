package com.carry.myproject.service.impl;

import com.carry.myproject.service.MQService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQServiceImpl implements MQService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String exchange, String routingKey, Object message) {
        amqpTemplate.convertAndSend(exchange, routingKey, message);
    }
}
