package servlet;

import entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Users users = new Users();

        String username;
        String mypassword;
        String gender;
        String email;
        String introduce;
        Date birthday = null;
        String[] favorites;
        String isAccept;

        username = req.getParameter("username");
        mypassword = req.getParameter("mypassword");
        gender = req.getParameter("gender");
        email = req.getParameter("email");
        introduce = req.getParameter("introduce");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = simpleDateFormat.parse(req.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 复选框的值
        favorites = req.getParameterValues("favorite");

        users.setUsername(username);
        users.setMypassword(mypassword);
        users.setGender(gender);
        users.setEmail(email);
        users.setIntroduce(introduce);
        users.setBirthday(birthday);
        users.setFavorites(favorites);
        if (req.getParameterValues("accept") != null) {
            users.setAccept(true);
        } else {
            users.setAccept(false);
        }

        req.getSession().setAttribute("regUser", users);
        req.getRequestDispatcher("../userinfo.jsp").forward(req, resp);
    }
}
