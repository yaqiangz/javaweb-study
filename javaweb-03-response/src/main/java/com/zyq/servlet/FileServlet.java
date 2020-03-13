package com.zyq.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1. 要获取下载文件的路径
        String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/测试.jpg");
        System.out.println("下载文件路径: " + realPath);
//        2. 下载的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("/") + 1);
//        3. 设置让浏览器能够支持下载, 解决中文文件名乱码URLEncoder.encode(fileName, "UTF-8"));
        resp.setHeader("Content-Disposition", "attachment; " +
                "filename="+ URLEncoder.encode(fileName, "UTF-8"));
//        4. 获取下载文件的输入流
        FileInputStream fileInputStream = new FileInputStream(realPath);
//        5. 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
//        6. 获取OutputStream对象
        ServletOutputStream outputStream = resp.getOutputStream();
//        7. 将FileOUtputStream写入到buffer缓冲区//        8. 使用OutputStream将缓冲区中的数据输出到客户端
        while ((len = fileInputStream.read(buffer))>0) {
            outputStream.write(buffer, 0, len);
        }
        fileInputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
