package com.net.jianshu.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener{
    private static  final Logger LOG = LoggerFactory.getLogger(SessionListener.class);
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

        LOG.info("监听器：----->sessionCreated()");
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        LOG.info("监听器：----->sessionDestroyed()");

    }
}
