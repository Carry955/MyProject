package com.carry.myproject.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**  默认过期时长为24小时，单位：秒 */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24L;
    /**  过期时长为1小时，单位：秒 */
    public final static long HOUR_ONE_EXPIRE = 60 * 60 * 1L;
    /**  过期时长为6小时，单位：秒 */
    public final static long HOUR_SIX_EXPIRE = 60 * 60 * 6L;
    /**  不设置过期时长 */
    public final static long NOT_EXPIRE = -1L;

    public void set(String key, Object value, long expire) {
        redisTemplate.opsForValue().set(key, value);
        if (expire != NOT_EXPIRE) {
            expire(key, expire);
        }
    }

    public void set(String key, Object value) {
        set(key, value, DEFAULT_EXPIRE);
    }

    public Object get(String key, long expire) {
        Object value = redisTemplate.opsForValue().get(key);
        if (expire != NOT_EXPIRE) {
            expire(key, expire);
        }
        return value;
    }

    public Object get(String key) {
        return get(key, NOT_EXPIRE);
    }

    public void expire(String key, long expire) {
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
