package com.carry.myproject.controller;

import com.carry.myproject.common.MQConst;
import com.carry.myproject.common.RequestMessage;
import com.carry.myproject.entity.HonorRecordEntity;
import com.carry.myproject.exception.FastException;
import com.carry.myproject.service.MQService;
import com.carry.myproject.service.RequestService;
import com.carry.myproject.utils.RedisUtil;
import com.carry.myproject.utils.Result;
import com.carry.myproject.vo.HonorRecordVO;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("request")
public class RequestController {
    @Autowired
    private MQService mqService;

    @Value("${file.uploadPath}")
    private String filePath;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RequestService requestService;

    private RateLimiter rateLimiter = RateLimiter.create(5);

    @PostMapping ()
    public Result<?> request(@RequestBody HonorRecordVO vo) {
        if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
            return Result.error("请求超时，请稍后再试");
        }

        int uid = 1;

        requestService.redisSave(uid, vo.getHid(), vo);
        mqService.sendMessage(MQConst.requestExchange, MQConst.requestKey, new RequestMessage(uid, vo));
        return Result.ok();
    }

    @GetMapping()
    public Result<?> get(Integer hid) {
        Integer uid = 1;
        HonorRecordVO vo = requestService.get(uid, hid);
        return Result.ok(vo);
    }

    @PostMapping("/upload")
    public Result<?> upload(MultipartFile file) {
        String realPath = filePath;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        if (file == null || file.isEmpty()) {
            throw new FastException("文件不存在");
        }

        String originFileName = file.getOriginalFilename();

        String suffix = originFileName.substring(originFileName.indexOf("."));
        String fileName = realPath + File.separator + UUID.randomUUID() + suffix;

        File newFile = new File(fileName);
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Result.ok(fileName);
    }
}
