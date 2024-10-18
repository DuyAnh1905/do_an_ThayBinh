package duyanh.dev.data.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import duyanh.dev.data.dao.CategoryDao;
import duyanh.dev.data.driver.MySQLDriver;
import duyanh.dev.data.model.Category;

public class CategoryImpl implements CategoryDao {

    Connection conn = MySQLDriver.getInstance().getConnection();

    @Override
    public boolean insert(Category category) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO CATEGORIES VALUES(NULL, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Category category) {
        // TODO Auto-generated method stub
        String sql = "UPDATE CATEGORIES SET name = ?, description = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.setInt(3, category.getId());
            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM CATEGORIES WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Category find(int id) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM CATEGORIES WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                return new Category(id, name, description);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        // TODO Auto-generated method stub
        List<Category> cateList = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIES";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                cateList.add(new Category(id, name, description));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cateList;
    }

    @Override
    public List<Category> hotCategory() {
        // TODO Auto-generated method stub
        List<Category> hotCategories = new ArrayList<>();
        String sql = "SELECT c.id, c.name, c.description "
                + "FROM CATEGORIES c "
                + "JOIN (SELECT category_id, COUNT(*) AS product_count "
                + "      FROM PRODUCTS "
                + "      GROUP BY category_id "
                + "      ORDER BY product_count DESC "
                + "      LIMIT 5) p ON c.id = p.category_id"; // Lấy 5 danh mục có sản phẩm nhiều nhất

        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                hotCategories.add(new Category(id, name, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotCategories;
    }
}
