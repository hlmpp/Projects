package servlet;

import com.po.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Users users = new Users();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        users.setUsername(username);
        users.setPassword(password);

        if (username.equals("admin") && password.equals("admin")) {
            resp.sendRedirect(req.getContextPath() + "/login_success.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login_failure.jsp");
        }
    }
}
