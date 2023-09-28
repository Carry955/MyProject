package com.carry.myproject.receiver;

import com.carry.myproject.common.MQConst;
import com.carry.myproject.service.MailService;
import com.carry.myproject.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MsgReceiver {
    @Autowired
    private SmsService smsService;

    @Autowired
    private MailService mailService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MQConst.smsQueue, durable = "true"),
            exchange = @Exchange(value = MQConst.msgExchange, type = ExchangeTypes.TOPIC),
            key = MQConst.smsRoutingKey
    ))
    public void sendSms(String msg) {
        log.info("smsListening...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        smsService.send(msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MQConst.mailQueue, durable = "true"),
            exchange = @Exchange(value = MQConst.msgExchange, type = ExchangeTypes.TOPIC),
            key = MQConst.mailRoutingKey
    ))
    public void sendMail(String msg) {
        log.info("mailListening...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mailService.send(msg);
    }
}
