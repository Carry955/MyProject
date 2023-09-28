package com.carry.myproject.service.impl;

import com.carry.myproject.exception.FastException;
import com.carry.myproject.service.DataSourceService;
import com.carry.myproject.vo.DataSourceVO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

@Service
public class DataSourceServiceImpl implements DataSourceService {

    @Override
    @Async
    public void test(DataSourceVO vo, SseEmitter sseEmitter) throws IOException {
        try {
            Thread.sleep(3000);
            Class.forName(vo.getDriverClass());
        } catch (ClassNotFoundException e) {
            sseEmitter.send("连接失败，找不到数据库驱动程序");
            sseEmitter.complete();
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(vo.getUrl(), vo.getUsername(), vo.getPassword())) {
            sseEmitter.send("连接成功");
        } catch (SQLException e) {
            sseEmitter.send("连接失败");
            e.printStackTrace();
        } finally {
            sseEmitter.complete();
        }
    }
}
