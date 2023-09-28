package com.carry.myproject.service;

import java.util.List;

public interface RecordService {
    void setSaveTask(String expression, long interval);

    List<String> list();

    void remove(String expression);
}
