package com.carry.myproject.service.impl;

import com.carry.myproject.component.RecordRunnable;
import com.carry.myproject.component.ScheduledTaskRegister;
import com.carry.myproject.dao.RecordDao;
import com.carry.myproject.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private ScheduledTaskRegister scheduledTaskRegister;

    @Autowired
    private RecordDao recordDao;
    @Override
    public void setSaveTask(String expression, long interval) {
        RecordRunnable runnable = new RecordRunnable(expression, recordDao);
        scheduledTaskRegister.addTask(runnable, interval);
    }

    @Override
    public List<String> list() {
        List<String> list = scheduledTaskRegister.getScheduledTaskMap().keySet().stream()
                .map(RecordRunnable.class::cast)
                .map(RecordRunnable::getExpression)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public void remove(String expression) {
        scheduledTaskRegister.removeTask(new RecordRunnable(expression, null));
    }
}
