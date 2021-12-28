package com.example.spring4.controller;

import com.example.spring4.domain.exception.UserNotFoundException;
import com.example.spring4.validation.validator.UserCreateDtoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dkotov
 * @since 23.12.2021
 */
@RestController
@ControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {
    private final UserCreateDtoValidator validator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String handleError(UserNotFoundException exception, HttpServletRequest request, HttpServletResponse response) {
        return "someError";
    }
}
