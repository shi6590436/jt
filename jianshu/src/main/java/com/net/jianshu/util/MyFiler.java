package com.net.jianshu.util;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter(urlPatterns = "/api/*",filterName = "login")
public class MyFiler implements Filter {
    private  static  final Logger LOG = LoggerFactory.getLogger(MyFiler.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    LOG.info("加载过滤器init()方法");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOG.info("处理过滤器请求doFilter()方法");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String userName = request.getParameter("userName");
        if("shi".equals(userName)){
            filterChain.doFilter(request,response);
        }else{
            response.sendRedirect("/index.html");
        }
    }

    @Override
    public void destroy() {
        LOG.info("过滤器销毁destroy()");

    }
}
