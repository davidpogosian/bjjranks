package com.bjjranks;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
	private Database database = new Database();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch(request.getServletPath()) {
            case "/handleResetDatabase":
                database.reset();
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.printf("GET request for: %s \n", request.getServletPath());
        switch(request.getServletPath()) {
            case "/hi":
                response.getWriter().println("Hello, Servlet!");
                break;
            case "/bye":
                response.getWriter().println("Goodbye, Servlet!");
                break;
            case "/login":
                try {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
