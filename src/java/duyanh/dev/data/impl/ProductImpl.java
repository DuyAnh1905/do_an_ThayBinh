package duyanh.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import duyanh.dev.data.dao.ProductDao;
import duyanh.dev.data.driver.MySQLDriver;
import duyanh.dev.data.model.Category;
import duyanh.dev.data.model.Product;
import duyanh.dev.data.model.User;

public class ProductImpl implements ProductDao {

    Connection conn = MySQLDriver.getInstance().getConnection();

    @Override
    public boolean insert(Product product) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO PRODUCTS(ID, NAME, DESCRIPTION, THUMBNAIL, PRICE, QUANTITY, CATEGORY_ID) VALUES(NULL, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getThumbnail());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            stmt.setInt(6, product.getCategoryId());

            stmt.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        // TODO Auto-generated method stub
        String sql = "UPDATE PRODUCTS SET name = ?, description = ?, thumbnail=?, price = ?, quantity = ?, category_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getThumbnail());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            stmt.setInt(6, product.getCategoryId());
            stmt.setInt(7, product.getId());

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

        String sql = "DELETE FROM PRODUCTS WHERE ID = ?";
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
    public Product find(int id) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM PRODUCTS WHERE ID = ?";
        Product product = null;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity,
                        view, categoryId, createdAt).println();
                product = new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return product; // Return the product, or null if not found
    }

    @Override
    public List<Product> findByCategory(int categoryId) {
        // TODO Auto-generated method stub
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE category_id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                Timestamp createdAt = rs.getTimestamp("created_at");

                productList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS ORDER BY VIEW DESC ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                productList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> hot(int limit) {
        List<Product> hotProducts = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS ORDER BY view DESC LIMIT ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, limit);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                hotProducts.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hotProducts;
    }

    @Override
    public List<Product> News(int limit) {
        List<Product> newProducts = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS ORDER BY created_at DESC LIMIT ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, limit);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                newProducts.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newProducts;
    }

    @Override
    public List<Product> findByName(String productName) {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE name LIKE ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            // Sử dụng LIKE với wildcard cho tìm kiếm sản phẩm theo tên
            stmt.setString(1, "%" + productName + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                // Thêm sản phẩm vào danh sách
                productList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> filter(int categoryId, String propertyName, String order) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE category_id = ? ORDER BY  " + propertyName + " " + order;

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> getProducts(int from, int amount) {
        // TODO Auto-generated method stub
        List<Product> productList = new ArrayList<>();
       String sql = "SELECT * FROM PRODUCTS LIMIT ?, ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, from);   // Tham số đầu tiên là 'from'
        stmt.setInt(2, amount); // Tham số thứ hai là 'amount'
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                // Thêm sản phẩm vào danh sách
            productList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return productList;
    }
}
