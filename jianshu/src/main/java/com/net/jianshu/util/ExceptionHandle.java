package com.net.jianshu.util;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandle {
    private  static  final Logger LOG = LoggerFactory.getLogger(ExceptionHandle.class);
    //定义捕获的是全局异常
    @ExceptionHandler(value = Exception.class)
    Object exceptionHandle(Exception e , HttpServletRequest request){
        LOG.error("msg {},url {}",e.getMessage(),request.getRequestURL());
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg",e.getMessage());
        map.put("url",request.getRequestURL());
        return  map;
    }

    @ExceptionHandler(value =MyExcption.class)
    Object myExcptionHandle(MyExcption e, HttpServletRequest request){

        //返回页面
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("error.html");
//        mv.addObject(e.getMessage());
//        return mv;
        //返回的是json数据
        LOG.error("msg {},url {}",e.getMessage(),request.getRequestURL());
        Map<String,Object> map = new HashMap<>();
        map.put("code",e.getCode());
        map.put("msg",e.getMsg());
        map.put("url",request.getRequestURL());
        return  map;


    }
}

