package com.lms.www.springboot.controller;

import com.lms.www.springboot.domain.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleIllegalArgumentException(EntityNotFoundException exception) {
        return exception.getMessage(); // 에러 페이지로의 뷰 이름을 리턴
    }
}