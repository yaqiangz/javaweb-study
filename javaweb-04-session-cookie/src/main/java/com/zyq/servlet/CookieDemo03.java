package com.zyq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

// 中文数据传递
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // Cookie, 服务器从客户端获取
        Cookie[] cookies = req.getCookies(); // 说明cookie可能存在多个
        // 判断cookie是否存在
        PrintWriter out = resp.getWriter();
        if (cookies != null) {
            // 如果存在
            out.write("你上一次访问的时间是: ");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                // 获取cookie的名字
                if (cookie.getName().equals("name")) {
                    System.out.println(cookie.getValue());
                    out.write(URLDecoder.decode(cookie.getValue(), "utf-8"));
                }
            }
        } else {
            out.write("这是您第一次访问本站");
        }

        Cookie cookie = new Cookie("name", URLEncoder.encode("啊啊啊", "utf-8"));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
