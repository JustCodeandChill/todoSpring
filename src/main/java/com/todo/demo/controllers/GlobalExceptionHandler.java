package com.todo.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        log.error("In the global exception handler");
        ModelAndView view = new ModelAndView();
        view.setViewName("errors");
        view.addObject("errorMsg", e.getMessage());
        return view;
    }
}
