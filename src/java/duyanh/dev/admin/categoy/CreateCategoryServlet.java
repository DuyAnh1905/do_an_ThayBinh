/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package duyanh.dev.admin.categoy;

import duyanh.dev.admin.BaseAdminServlet;
import duyanh.dev.data.dao.DatabaseDao;
import duyanh.dev.data.dao.CategoryDao;
import duyanh.dev.data.model.Category;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class CreateCategoryServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("admin/category/create.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String thumbnail = request.getParameter("thumbnail");
        
        HttpSession session = request.getSession();
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();

        if (name.isEmpty() || thumbnail.isEmpty()) {
            session.setAttribute("error", "vi long dien day du thong tinh");
            request.getRequestDispatcher("admin/category/create.jsp").include(request, response);
        
        } else {
            Category category = new Category(name, thumbnail);
            categoryDao.insert(category);
            response.sendRedirect("CreateCategoryServlet");
        }
    }
}
