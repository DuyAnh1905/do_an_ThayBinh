package duyanh.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryImpl {

    private Connection conn;

    public CategoryImpl(Connection conn) {
        super();
        this.conn = conn;
    }

    public void findAll() {
        // TODO Auto-generated method stub

        String sql = "SELECT * FROM CATEGORIES";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                System.out.format("%id:%s:%s", id, name, description).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void find() {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM CATEGORIES WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 1); //id la id của category cần tìm
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                System.out.format("%id:%s:%s", 1, name, description).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void select() {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM CATEGORIES";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                System.out.format("id:%d - name:%s - description:%s", id, name, description).println();
            }
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void delete() {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM CATEGORIES WHERE ID=? ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, 1);

            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void update() {
        // TODO Auto-generated method stub
        String sql = "UPDATE CATEGORIES SET NAME=?, description=? WHERE ID=? ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "Ao nU");
            stmt.setString(2, "https://image.com/2.jpg");
            stmt.setInt(3, 1);

            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void insert() {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO CATEGORIES(NAME, description) VALUES (?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "quan nam");
            stmt.setString(2, "https://image.com/2.jpg");

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
