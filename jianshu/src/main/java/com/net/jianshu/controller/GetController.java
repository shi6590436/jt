package com.net.jianshu.controller;

import com.net.jianshu.pojo.TestResource;
import com.net.jianshu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController

public class GetController {
    Map<String,Object>params =new HashMap<>();
    @GetMapping(value = "/v1/v2")
    public Object getPage(int page,int size){
        params.clear();
        params =new HashMap<>();
        params.put("page",page);
        params.put("size",size);
        return  params;
    }

    @GetMapping(value = "/v1/v3")
    public Object getPage1(@RequestParam(defaultValue = "0",name = "a") int page, int size){
        params.clear();
        params =new HashMap<>();
        params.put("page",page);
        params.put("size",size);
        return  params;
    }
    @RequestMapping(value = "/v1/v4")
    public Object getUser(@RequestBody User user){
        params.clear();
        params =new HashMap<>();
        params.put("user",user);
        return  params;
    }
    @GetMapping(value = "/v1/v5")
    public Object getHeader(@RequestHeader("access_token")String access_token ,String id){
        params.clear();
        params.put("access_token",access_token);
        params.put("id",id);
        return  params;
    }
    @GetMapping(value = "/v1/v6")
    public Object getRequest(HttpServletRequest request){
        params.clear();
        String id = request.getParameter("id");
        params.put("id",id);
        return  params;
    }


    @Autowired
    private TestResource test;
    @GetMapping(value = "/resources")
    public Object getResources(){
        return  test;
    }

    @GetMapping(value = "/api/login")
    public Object getLogin(){
        params.clear();
       String account = "100000";
        params.put("account",account);
        return  params;
    }


}
