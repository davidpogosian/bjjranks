package com.bjjranks;

import java.io.IOException;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        switch(request.getServletPath()) {
            case "/handleResetDatabase":
                //database.reset();
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.printf("GET request for: %s \n", request.getServletPath());

        ArrayList<String> path = parsePath(request.getServletPath());
        Router router = new Router(path, request, response);
        router.respond();
    }

    private ArrayList<String> parsePath(String path) {
		String[] rawPath = path.split("/");
		ArrayList<String> refinedPath = new ArrayList<String>();
		for (String str : rawPath) {
		    if (!str.equals("")) {
		        refinedPath.add(str);
		    }
		}
        return refinedPath;
    }
}