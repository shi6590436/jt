package com.net.jianshu.controller;

import com.net.jianshu.pojo.User;
import com.net.jianshu.util.JsonUtils;
import com.net.jianshu.util.JsonsData;
import com.net.jianshu.util.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.jvm.hotspot.oops.ObjArrayKlass;

import javax.naming.Name;
import java.util.Date;

@RestController
@RequestMapping("/redis")
public class redisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisClient redisClient;

    @GetMapping("add")
    public Object addRedis(){
        stringRedisTemplate.opsForValue().set("time","tomorrow");
        return JsonsData.buildSuccess();
    }
    @GetMapping("get")
    public Object get(){
        String value = redisClient.get("name");
        System.out.println("获取的name为"+value);
        return JsonsData.buildSuccess(value);
    }
    @GetMapping("addUser")
    public Object addUser(){
        User user = new User();
        user.setName("刘备");
        user.setId(123);
        user.setPhone("3254675");
        user.setCreateTime(new Date());
        String userStr = JsonUtils.obj2String(user);
        redisClient.set("base:user:11",userStr);
        return JsonsData.buildSuccess();
    }

    @GetMapping("getUser")
    public Object getUser(){
        String value = redisClient.get("base:user:11");
        System.out.println("获取的user为"+value);
        return JsonsData.buildSuccess(value);

    }

}
