package com.net.jianshu.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener{
    private static  final Logger LOG = LoggerFactory.getLogger(RequestListener.class);
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
    LOG.info("监听器：----->requestDestroyed()");

    }
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        LOG.info("监听器：------>requestInitialized()");
    }
}
