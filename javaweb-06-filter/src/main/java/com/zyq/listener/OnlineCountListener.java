package com.zyq.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// 统计网站在线人数: 统计session
public class OnlineCountListener implements HttpSessionListener {
    // 创建session监听
    // 一旦创建Session 就会触发一次这个事件
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");
        System.out.println(httpSessionEvent.getSession().getId());
        if (onlineCount == null)
            onlineCount = new Integer(1);
        else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count+1);
        }
        servletContext.setAttribute("OnlineCount", onlineCount);
    }

    // 销毁session监听
    // 一旦销毁Session就会触发一次这个事件
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("OnlineCount");
        if (onlineCount == null)
            onlineCount = new Integer(0);
        else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count-1);
        }
        servletContext.setAttribute("OnlineCount", onlineCount);

        /*
        Session销毁:
        1. 自动销毁: xml中配置session-timeout
        2. 手动销毁httpSessionEvent.getSession().invalidate()
         */
    }
}
