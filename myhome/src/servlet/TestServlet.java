package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 以下是在当前路径下寻求这个页面。当前路径参考部署文件里面的配置路径，需要考虑到项目和虚拟路径。
//        resp.sendRedirect("../test.jsp");
        // 或者使用以下方式来访问。
//        resp.sendRedirect(req.getContextPath() + "/test.jsp");
        // 以下是服务器内部跳转，这里的斜线表示项目的根目录。
        req.getRequestDispatcher("/test.jsp").forward(req, resp);
    }
}
