package com.net.jianshu.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HeaderController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot 热加载 ";
    }

}
