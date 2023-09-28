package com.carry.myproject.utils;

import com.carry.myproject.exception.FastException;
import com.carry.myproject.security.user.UserDetail;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static UserDetail getUserDetail() {
        try {
            System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FastException("获取当前用户信息失败");
        }
    }
}
