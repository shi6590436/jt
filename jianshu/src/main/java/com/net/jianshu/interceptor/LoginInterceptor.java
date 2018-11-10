package com.net.jianshu.interceptor;

import com.net.jianshu.listener.ContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 过滤器
 */

public class LoginInterceptor implements HandlerInterceptor{
    private static  final Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * 进入controller方法之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("拦截器：preHandle()");

      return HandlerInterceptor.super.preHandle(request, response, handler);
    }
    /**
     * 调用完controller之后，视图渲染之前
     */

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        LOG.info("拦截器：postHandle()");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
    /**
     * 整个完成之后，通常用于资源清理
     */

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        LOG.info("拦截器：afterCompletion()");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);

    }
}
