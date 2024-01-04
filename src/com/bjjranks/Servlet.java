package com.bjjranks;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
	private Database database = new Database();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        switch(request.getServletPath()) {
            case "/hi":
                response.getWriter().println("Hello, Servlet!");
                break;
            case "/bye":
                response.getWriter().println("Goodbye, Servlet!");
                break;
            case "/handleResetDatabase":
                database.reset();
            default:
		        System.out.println("Get request to /.");
                try {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
