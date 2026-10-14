package com.sumanezhumalai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("InService");

        PrintWriter out = res.getWriter();
        // out.println("Hello Suman!");

        res.setContentType("text/html");
        out.write("<h1>Hello from Embedded Tomcat Servlet!</h1>");
    }
}
