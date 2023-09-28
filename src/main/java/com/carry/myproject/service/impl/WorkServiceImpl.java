package com.carry.myproject.service.impl;

import com.carry.myproject.service.WorkService;
import com.carry.myproject.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private RedisUtil redisUtils;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd::HH:mm");
    @Override
    @Async
    public void execute() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("--- Async Work finished! ---");
        redisUtils.set("work::" + sdf.format(new Date()), new Date());
    }
}
