package com.carry.myproject.controller;

import com.carry.myproject.service.RecordService;
import com.carry.myproject.utils.Result;
import com.carry.myproject.vo.RecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("record")
public class RecordController {

    @Autowired
    RecordService recordService;

    @PutMapping("/set")
    public Result<?> add(@RequestBody RecordVO recordVO) {
        recordService.remove(recordVO.getExpression());
        recordService.setSaveTask(recordVO.getExpression(), recordVO.getInterval());
        return Result.ok();
    }

    @GetMapping("/list")
    public Result<List<String>> list() {
        List<String> list = recordService.list();
        return Result.ok(list);
    }

    @DeleteMapping("/cancel")
    public Result<?> remove(@RequestParam String expression) {
        recordService.remove(expression);
        return Result.ok();
    }
}
