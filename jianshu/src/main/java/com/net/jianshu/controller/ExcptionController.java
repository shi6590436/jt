package com.net.jianshu.controller;

import com.net.jianshu.pojo.User;
import com.net.jianshu.util.MyExcption;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ExcptionController {
    Map<String,Object>params =new HashMap<>();
    @GetMapping(value = "/v1/exc")
    public Object getExcption(){
        int i = 1/0;
        return new User();

    }


    @RequestMapping(value = "/v1/my_ext")
    public Object getMyExcption(){
       throw   new MyExcption("501","访问不存在");
    }
}
