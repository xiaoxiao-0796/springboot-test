package com.xiaofei.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller统一处理异常类
 * Created by xiaofei
 * Created at 2017/4/24.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView errorhandler(HttpServletRequest request,Exception e){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("msg",e.getMessage());
        modelAndView.addObject("url",request.getRequestURL());
        return modelAndView;
    }
}
