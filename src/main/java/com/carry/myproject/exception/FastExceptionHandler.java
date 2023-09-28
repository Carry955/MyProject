package com.carry.myproject.exception;

import com.carry.myproject.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class FastExceptionHandler {
    @ExceptionHandler(FastException.class)
    public Result<String> handlerFastException(FastException e) {
        return Result.error(e.getCode(), e.getMsg());
    }
}
