package com.carry.myproject.service.impl;

import com.carry.myproject.common.MQConst;
import com.carry.myproject.service.MQService;
import com.carry.myproject.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements MsgService {
    @Autowired
    private MQService mqService;

    @Override
    public void send(String type, String msg) {
        String routing_key = "queue." + type;
        mqService.sendMessage(MQConst.msgExchange, routing_key, msg);
    }
}
