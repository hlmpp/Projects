package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by pengchen on 9/13/18.
 */
public class TestServlet2 extends HttpServlet {
    public TestServlet2() {
        System.out.println("TestServlet2 construct method");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("TestServlet2 init method");
    }

    @Override
    public void destroy() {
        System.out.println("TestServlet2 destroy method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("TestServlet2 doGet method");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Hello, I am TestServlet2</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
