package com.net.jianshu.controller;

import com.net.jianshu.pojo.User;
import com.net.jianshu.service.UserService;
import com.net.jianshu.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping("add")
//    public JsonData add(){
//        User user  = new User();
//        user.setAge(11);
//        user.setCreateTime(new Date());
//        user.setPhone("1223455");
//        user.setName("刘备");
//        int id =userService.add(user);
//        return new JsonData("201","成功",id);
//
//    }

}
