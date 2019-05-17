package com.module;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet",urlPatterns = "/dictionary")
public class TranslateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        translate(request, response);
    }

    private void translate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String en = request.getParameter("en");
        PrintWriter writer = response.getWriter();

        translateEnVi(en, writer);
    }

    private void translateEnVi(String en, PrintWriter writer) {
        getData(en, writer);
    }

    private void getData(String en, PrintWriter writer) {
        Map<String, String> map = data();

        String vi = map.get(en);

        if (vi != null) {
            writer.println("EN: " + en);
            writer.println("VI: " + vi);
        } else {
            writer.println("Not found");
        }
    }

    private Map<String, String> data() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "xin chao");
        map.put("apple", "qua tao");
        return map;
    }
}
