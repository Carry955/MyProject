package com.carry.myproject.controller;

import com.carry.myproject.service.CaptchaService;
import com.carry.myproject.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("captcha")
public class CaptchaController {
    public final static String SESSION_KEY_IMAGE_CODE = "SESSION_KEY_IMAGE_CODE";
    @Autowired
    private CaptchaService captchaService;

    @GetMapping("/get")
    public Result<String> getCaptcha(HttpServletRequest request, @RequestParam("username") String username) {
        String key = UUID.randomUUID().toString();
        String captchaImg = captchaService.getCaptcha(key);
        HttpSession session = request.getSession();
        session.setAttribute(SESSION_KEY_IMAGE_CODE, key);
        return Result.ok(captchaImg);
    }
}
