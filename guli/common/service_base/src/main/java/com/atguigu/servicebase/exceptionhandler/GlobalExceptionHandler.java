package com.atguigu.servicebase.exceptionhandler;

import com.atguigu.commonutils.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.AuthenticationException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultData error(Exception e){
        e.printStackTrace();
        return ResultData.error().message("执行了全局异常处理");
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResultData nullPointerException(NullPointerException e){
        e.printStackTrace();
        return ResultData.error().message("空指针异常处理");
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ResultData arithmeticException(ArithmeticException e){
        e.printStackTrace();
        return ResultData.error().message("ArithmeticException异常处理");
    }

    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public ResultData guliException(GuliException e){
        log.error(e.getMsg());
        e.printStackTrace();
        return ResultData.error().code(e.getCode()).message(e.getMsg());
    }

}
