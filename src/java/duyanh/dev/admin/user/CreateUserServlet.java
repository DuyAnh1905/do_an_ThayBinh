/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package duyanh.dev.admin.user;

import duyanh.dev.admin.BaseAdminServlet;
import duyanh.dev.data.dao.DatabaseDao;
import duyanh.dev.data.dao.UserDao;
import duyanh.dev.data.model.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class CreateUserServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("admin/user/create.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String role = request.getParameter("role");
        HttpSession session = request.getSession();
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(email);

        if (email.isEmpty() || password.isEmpty() || repassword.isEmpty() || role.isEmpty()) {
            session.setAttribute("error", "vi long dien day du thong tinh");
            request.getRequestDispatcher("admin/user/create.jsp").include(request, response);
        } else if (user != null) {
            session.setAttribute("error", "da ton tai email");
            request.getRequestDispatcher("admin/user/create.jsp").include(request, response);
        } else if (!password.equals(repassword)) {
            session.setAttribute("error", "mat kho khong khop ");
            request.getRequestDispatcher("admin/user/create.jsp").include(request, response);
        } else {
            user = new User(email, password, role);
            userDao.insert(user);
            response.sendRedirect("CreateUserServlet");
        }
    }
}
