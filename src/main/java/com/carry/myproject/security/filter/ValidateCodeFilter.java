package com.carry.myproject.security.filter;

import cn.hutool.core.util.StrUtil;
import com.carry.myproject.controller.CaptchaController;
import com.carry.myproject.exception.FastException;
import com.carry.myproject.security.exception.FastAuthenticationException;
import com.carry.myproject.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class ValidateCodeFilter extends OncePerRequestFilter {

    @Autowired
    private CaptchaService captchaService;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if ((StrUtil.equalsIgnoreCase("/login", request.getRequestURI())
                || StrUtil.equalsIgnoreCase("/oauth/token", request.getRequestURI()))
                && StrUtil.equalsIgnoreCase("post", request.getMethod())) {
            try {
                validateCode(request);
            } catch (AuthenticationException e) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void validateCode(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String key = (String) session.getAttribute(CaptchaController.SESSION_KEY_IMAGE_CODE);
        String code = request.getParameter("imageCode");

        try {
            boolean flag = captchaService.validate(key, code);
            if (!flag) {
                throw new FastAuthenticationException("验证码错误");
            }
        } catch (FastException e) {
            throw new FastAuthenticationException(e.getMsg());
        }
        request.removeAttribute(CaptchaController.SESSION_KEY_IMAGE_CODE);
    }
}
