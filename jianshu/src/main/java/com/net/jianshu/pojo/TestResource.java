package com.net.jianshu.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:application.properties"})
@ConfigurationProperties(prefix="test")
public class TestResource {
//    @Value("${test.name}")
    private  String  name ;
//    @Value("${test.age}")
    private  String  age ;

    public String getName() {
        return name;
    }

    public TestResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    public TestResource setAge(String age) {
        this.age = age;
        return this;
    }
}
