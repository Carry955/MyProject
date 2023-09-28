package com.carry.myproject.service.impl;

import com.carry.myproject.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmsServiceImpl implements SmsService {
    @Override
    public boolean send(String msg) {
        log.info("sms: " + msg);
        return true;
    }
}
