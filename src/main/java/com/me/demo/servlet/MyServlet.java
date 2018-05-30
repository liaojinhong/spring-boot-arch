package com.me.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 自定义MyServlet
 * 
 * @author ljh
 *
 */
//这里采用代码注册,见ServletConfig类，所以不需再要以下标签
//@Configuration
//@ServletComponentScan
//@WebServlet(urlPatterns="/xs/myServlet")
//启动后访问 http://localhost:7001/xs/myServlet 发现servlet已经成功发布了。
public class MyServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	logger.info(">>>>>>>>>>doGet()<<<<<<<<<<<");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	logger.info(">>>>>>>>>>doPost()<<<<<<<<<<<");
        resp.setContentType("text/html");  
        PrintWriter out = resp.getWriter();  
        out.println("<html>");  
        out.println("<head>");  
        out.println("<title>Hello World</title>");  
        out.println("</head>");  
        out.println("<body>");  
        out.println("<h1>大家好，我的名字叫Servlet</h1>");  
        out.println("</body>");  
        out.println("</html>"); 
    }

}