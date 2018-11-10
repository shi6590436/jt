package com.net.jianshu.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener{
    private static  final Logger LOG = LoggerFactory.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOG.info("监听器：contextInitialized()");

    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOG.info("监听器 contextDestroyed()");

    }
}
