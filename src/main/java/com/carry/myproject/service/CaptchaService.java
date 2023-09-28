package com.carry.myproject.service;

public interface CaptchaService {
    public String getCaptcha(String username);

    public boolean validate(String key, String code);
}
