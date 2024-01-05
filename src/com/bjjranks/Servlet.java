package com.bjjranks;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {
	private Database database = new Database();
    String var = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        switch(request.getServletPath()) {
            case "/handleResetDatabase":
                database.reset();
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.printf("GET request for: %s \n", request.getServletPath());

        //parsePath(request, response);

        switch(request.getServletPath()) {
            case "/write":
                var = "SKIBIDI";
                response.getWriter().printf("Wrote, var: $s", var);
                break;
            case "/read":
                response.getWriter().printf("var: $s", var);
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

    // private void parsePath(HttpServletRequest request, HttpServletResponse response) {
    //     String path = request.getServletPath();
	// 	String[] splitPath = path.split("/");
	// 	ArrayList<String> cleanPath = new ArrayList<String>();
	// 	for (String str : splitPath) {
	// 	    if (!str.equals("")) {
	// 	        cleanPath.add(str);
	// 	    }
	// 	}
    // }
}
