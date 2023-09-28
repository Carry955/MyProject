package com.carry.myproject.utils;

public class RedisKeyAdapter {
    public static String getCaptchaKey(String key) {
        return "sys:captcha:" + key;
    }

    public static String getOauthCode(String code) {
        return "oauth:code:" + code;
    }
}
