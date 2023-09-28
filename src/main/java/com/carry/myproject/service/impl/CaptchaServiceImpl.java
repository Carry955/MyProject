package com.carry.myproject.service.impl;

import cn.hutool.core.util.StrUtil;
import com.carry.myproject.exception.FastException;
import com.carry.myproject.service.CaptchaService;
import com.carry.myproject.utils.RedisUtil;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaptchaServiceImpl implements CaptchaService {
    private final static String captchaPrefix = "captcha:";
    @Autowired
    private RedisUtil redisUtils;

    @Override
    public String getCaptcha(String key) {
        SpecCaptcha captcha = new SpecCaptcha(150, 40);
        captcha.setLen(5);
        captcha.setCharType(Captcha.TYPE_DEFAULT);
        redisUtils.set(captchaPrefix + key, captcha.text(), 300);

        return captcha.toBase64();
    }

    @Override
    public boolean validate(String key, String code) {
        if (StrUtil.isBlank(code)) {
            throw new FastException("验证码不能为空");
        }
        if (StrUtil.isBlank(key)) {
            throw new FastException("请先获取验证码");
        }

        String captchaCode = (String) redisUtils.get(captchaPrefix + key);

        if (captchaCode == null) {
            throw new FastException("验证码已过期");
        }
        redisUtils.delete(captchaPrefix + key);

        return StrUtil.equalsIgnoreCase(code, captchaCode);
    }
}
