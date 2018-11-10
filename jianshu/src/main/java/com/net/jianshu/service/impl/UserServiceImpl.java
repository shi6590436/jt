package com.net.jianshu.service.impl;

import com.net.jianshu.mapper.UserMapper;
import com.net.jianshu.pojo.User;
import com.net.jianshu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService{
//    @Autowired
//    private UserMapper userMapper;

    @Override
    public int add(User user) {
        return 0;
    }

//    @Override
//    public int add(User user) {
//        userMapper.insert(user);
//        int id = user.getId();
//
//        return id;
//    }
}
