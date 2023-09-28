package com.carry.myproject.receiver;

import com.carry.myproject.common.MQConst;
import com.carry.myproject.common.RequestMessage;
import com.carry.myproject.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReentrantLock;

@Component
@Slf4j
public class RequestReceiver {
    @Autowired
    private RequestService requestService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MQConst.requestQueue, durable = "true"),
            exchange = @Exchange(value = MQConst.requestExchange)
    ), concurrency = "5")
    public void doProcess(RequestMessage message) {
        log.info("接收到消息：{}", message);
        requestService.process(message.getUid(), message.getVo());
    }
}
