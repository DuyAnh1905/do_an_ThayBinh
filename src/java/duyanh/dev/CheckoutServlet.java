/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package duyanh.dev;

import duyanh.dev.data.dao.DatabaseDao;
import duyanh.dev.data.dao.OrderItemDao;
import duyanh.dev.data.dao.OrderDao;
import duyanh.dev.data.dao.OrderItemDao;
import duyanh.dev.data.model.Order;
import duyanh.dev.data.model.OrderItem;
import duyanh.dev.data.model.User;
import duyanh.dev.util.StringHelper;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import jdk.javadoc.doclet.Reporter;

/**
 *
 * @author Admin
 */
public class CheckoutServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("LoginServlet");
        } else {
            ProcessorCheckout(request, user);
            response.sendRedirect("CartServlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void ProcessorCheckout(HttpServletRequest request, User user) {
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        String code = StringHelper.randomString(10);
        Order order = new Order(code, "pending", user.getId());
        orderDao.insert(order);

        order = orderDao.findByCode(code);
        HttpSession session = request.getSession();
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");
        
        OrderItemDao orderItemDao =DatabaseDao.getInstance().getOrderItemDao();
        
        if (cart != null) {
            for (OrderItem orderItem : cart) {
                orderItem.setOrderId(order.getId());
                orderItemDao.insert(orderItem);
            }
        }
    session.setAttribute("message", "Cheokout Success");
    session.removeAttribute("cart");
    }
}
