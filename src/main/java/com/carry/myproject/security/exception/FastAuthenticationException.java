package com.carry.myproject.security.exception;

import org.springframework.security.core.AuthenticationException;

public class FastAuthenticationException extends AuthenticationException {
    public FastAuthenticationException(String msg) {
        super(msg);
    }
}
