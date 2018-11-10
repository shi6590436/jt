package com.net.jianshu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling //开启定时任务的配置
@EnableAsync //开启异步任务
public class JianshuApplication {

	public static void main(String[] args) {
		SpringApplication.run(JianshuApplication.class, args);
	}
}
