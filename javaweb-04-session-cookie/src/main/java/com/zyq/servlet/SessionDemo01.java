package com.zyq.servlet;

import com.zyq.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        // 得到Session
        HttpSession session = req.getSession();
        // 在Session中存东西
        session.setAttribute("name", new Person("啦啦啦", 6));
        // 获取Session的ID
        String sessionId = session.getId();
        // 判断Session是不是新创建
        if (session.isNew()) {
            resp.getWriter().write("session创建成功, ID: " + sessionId);
        } else {
            resp.getWriter().write("session已存在, ID: " + sessionId);
        }

        // Session创建的时候做了?
//        Cookie cookie = new Cookie("JSESSIONID", sessionId);
//        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
