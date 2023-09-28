package com.carry.myproject.service.impl;

import com.carry.myproject.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailServiceImpl implements MailService {
    @Override
    public boolean send(String msg) {
        log.info("mail: " + msg);
        return true;
    }
}
