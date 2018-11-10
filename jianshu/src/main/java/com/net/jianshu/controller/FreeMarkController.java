package com.net.jianshu.controller;


import com.net.jianshu.pojo.TestResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freeMark")
public class FreeMarkController {
    @Autowired
    private TestResource testResource;
    @GetMapping("/hello")
    public  String getIndex(ModelMap modelMap){

        modelMap.addAttribute("testResource",testResource);
        return "fm/index";
    }


}
