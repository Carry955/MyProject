package com.carry.myproject.service;

import com.carry.myproject.vo.DataSourceVO;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

public interface DataSourceService {
    public void test(DataSourceVO vo, SseEmitter sseEmitter) throws IOException;
}
