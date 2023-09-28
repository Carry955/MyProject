package com.carry.myproject.controller;

import com.carry.myproject.service.MsgService;
import com.carry.myproject.service.WorkService;
import com.carry.myproject.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("work")
public class WorkController {
    @Autowired
    private WorkService workService;

    @Autowired
    private MsgService msgService;

    @PostMapping("/execute")
    public Result<?> work() {
        workService.execute();
        return Result.ok();
    }

    @PutMapping("/send")
    public Result<?> sendMsg(String type, String msg) {
        msgService.send(type, msg);
        return Result.ok();
    }
}
