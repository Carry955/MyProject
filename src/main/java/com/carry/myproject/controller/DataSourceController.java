package com.carry.myproject.controller;

import com.carry.myproject.service.DataSourceService;
import com.carry.myproject.service.SmsService;
import com.carry.myproject.utils.Result;
import com.carry.myproject.vo.DataSourceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
@RequestMapping("datasource")
public class DataSourceController {

    @Autowired
    private DataSourceService dataSourceService;

    private
    SseEmitter sseEmitter;

    @PostMapping("/test")
    public SseEmitter testConnection(@RequestBody DataSourceVO vo) throws IOException {

        sseEmitter = new SseEmitter(0L);

        sseEmitter.send("连接测试中...", MediaType.APPLICATION_JSON);

        dataSourceService.test(vo, sseEmitter);

        return sseEmitter;
    }

}
