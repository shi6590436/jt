package com.net.jianshu.logBack;

import com.net.jianshu.util.JsonsData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

public class LogBackController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping("log")
    public Object testLog(){

        logger.debug("this is debug level");
        logger.info("this is info level ");
        logger.warn("this is warn level ");
        logger.error("this is error level");
        return JsonsData.buildSuccess();
    }
}
