package com.zyq.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    // Web服务器启动时就初始化了
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("characterEncoding初始化");
    }

    /*
    1. 过滤器中的所有代码, 在过滤特定请求的时候都会执行
    2. 必须要让过滤器继续通行
        filterChain.doFilter(servletRequest, servletResponse);
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        System.out.println("CharacterEncoding执行前");
        filterChain.doFilter(servletRequest, servletResponse); // 让程序继续走
        System.out.println("CharacterEncoding执行后");
    }
    // Web服务器关闭的时候会销毁
    @Override
    public void destroy() {
        System.out.println("characterEncoding销毁");
    }
}
