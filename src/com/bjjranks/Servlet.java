package com.bjjranks;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        switch(request.getServletPath()) {
            case "/hi":
                response.getWriter().println("Hello, Servlet!");
                break;
            case "/bye":
                response.getWriter().println("Goodbye, Servlet!");
                break;
        }
        
    }
}
