package servlet;

import dao.ItemsDao;
import entity.Cart;
import entity.Items;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends HttpServlet {
    private String action;
    private ItemsDao itemsDao = new ItemsDao();

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        if (req.getParameter("action") != null) {
            this.action = req.getParameter("action");
            if (action.equals("add")) {
                if (addToCart(req, resp)) {
                    req.getRequestDispatcher(req.getContextPath() + "/success.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher(req.getContextPath() + "/failure.jsp").forward(req, resp);
                }
            }

            if (action.equals("show")) {
//                showCart(req, resp);
                req.getRequestDispatcher(req.getContextPath() + "/cart.jsp").forward(req, resp);
            }
            if (action.equals("delete")){
                if (deleteFromCart(req, resp)) {
                    req.getRequestDispatcher(req.getContextPath() + "/cart.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher(req.getContextPath() + "/cart.jsp").forward(req, resp);
                }
            }
        }

    }

    private boolean addToCart(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String number = request.getParameter("num");

        Items items = itemsDao.getItemsById(Integer.parseInt(id));

        if (request.getSession().getAttribute("cart") == null) {
            Cart cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        Cart cart = (Cart)request.getSession().getAttribute("cart");

        if (cart.addGoodsInCart(items, Integer.parseInt(number))) {
            return true;
        }
        return false;
    }

    private boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        Items items = itemsDao.getItemsById(Integer.parseInt(request.getParameter("id")));
        if (cart.removeGoodsFromCart(items)) {
            return true;
        }

        return  false;
    }
}
