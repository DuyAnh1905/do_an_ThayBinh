package duyanh.dev.data;

import java.sql.Connection;

import java.sql.Timestamp; // Import đúng gói
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductImpl {

    private Connection conn;

    public ProductImpl(Connection conn) {
        super();
        this.conn = conn;
    }

    public int insert() {
        String sql = "INSERT INTO PRODUCTS(ID, NAME, DESCRIPTION, THUMBNAIL, PRICE, QUANTITY, CATEGORY_ID) VALUES(NULL, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, "product Name");
            stmt.setString(2, "product Description");
            stmt.setString(3, "product Thumbnail");
            stmt.setDouble(4, 100);
            stmt.setInt(5, 10);
            stmt.setInt(6, 1);

            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            return generatedKey;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public boolean update() {
        String sql = "UPDATE PRODUCTS SET name = ?, description = ?, thumbnail=?, price = ?, quantity = ?, category_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "hotao");
            stmt.setString(2, "Description");
            stmt.setString(3, "Thumbnail");
            stmt.setDouble(4, 101);
            stmt.setInt(5, 10);
            stmt.setInt(6, 1);
            stmt.setInt(7, 8);

            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

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

    public void find(int id) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM PRODUCTS WHERE ID = ?";
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
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void findAll() {
        // TODO Auto-generated method stub
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
                System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity,
                        view, categoryId, createdAt).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void hot(int limit) {
        String sql = "SELECT * FROM PRODUCTS ORDER BY VIEW DESC LIMIT ?";
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
                System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity,
                        view, categoryId, createdAt).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void findByCategory(int categoryId) {
        // TODO Auto-generated method stub
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
                System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity,
                        view, categoryId, createdAt).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//	public void relatedProductList(Product product) {
//		String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY_ID = ? LIMIT ?";
//		try {
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setInt(1, product.getCategoryId());
//			stmt.setInt(2, Constants.RELATED_NUMBER);
//
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				int id = rs.getInt("id");
//				String name = rs.getString("name");
//				String description = rs.getString("description");
//				String thumbnail = rs.getString("thumbnail");
//				double price = rs.getDouble("price");
//				int quantity = rs.getInt("quantity");
//				int view = rs.getInt("view");
//				int categoryId = rs.getInt("category_id");
//				Timestamp createdAt = rs.getTimestamp("created_at");
//
//				System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity,
//						view, categoryId, createdAt).println();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public void findByCategory(int categoryId) {
//        // TODO Auto-generated method stub
//        String sql = "SELECT * FROM PRODUCTS WHERE category_id = ?";
//        try {
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setInt(1, categoryId);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String description = rs.getString("description");
//                String thumbnail = rs.getString("thumbnail");
//                double price = rs.getDouble("price");
//                int quantity = rs.getInt("quantity");
//                int view = rs.getInt("view");
//                Timestamp createdAt = rs.getTimestamp("created_at");
//                System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity, view, categoryId, createdAt).println();
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
    //Lọc sản phẩm theo category, thuộc tính, sắp xếp thứ tự
    public void filter(int categoryId, String propertyName, String order) {
        String sql = "SELECT * FROM PRODUCTS WHERE category_id = ? ORDER BY ? ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            stmt.setString(2, propertyName);
            stmt.setString(3, order);
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
                System.out.format("%d:%s:%s:%s:%.2f:%d:%d:%d,:%s", id, name, description, thumbnail, price, quantity, view, categoryId, createdAt).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
