package com.bjjranks;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Router {
    Responder responder;
    private int cursor = 0;
    ArrayList<String> path;
    HttpServletRequest request;
    HttpServletResponse response;

    public Router(ArrayList<String> path, HttpServletRequest request, HttpServletResponse response) {
        this.path = path;
        this.request = request;
        this.response = response;
        responder = new Responder(request, response);
    }

    public void respond() {
        root();
    }

    private void root() {
        if (atEnd()) {
            System.out.println("Root");
            // Is it possible to request bjjranks.com/?
            return;
        }

        switch (path.get(cursor++)) {
            case "index.html":
                responder.root();
                break;
            case "users":
                users();
                break;
            default:
                notFound();
                break;

        }
    }

    private void users() {
        if (atEnd()) {
            System.out.println("Users");
            responder.users();
            return;
        }

        switch (path.get(cursor++)) {
            case "david":
                david();
                break;
            default:
                notFound();
                break;

        }
    }

    private void david() {
        if (atEnd()) {
            System.out.println("David");
            responder.david();
            return;
        }

        switch (path.get(cursor++)) {
            default:
                notFound();
                break;
        }
    }

    private void notFound() {
        responder.notFound();
    }

    private boolean atEnd() {
        return cursor == path.size();
    }
}
