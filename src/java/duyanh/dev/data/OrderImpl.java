package duyanh.dev.data;

import java.sql.Timestamp; // Import đúng gói
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderImpl {

    private Connection conn;

    public OrderImpl(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean insert() {
        String sql = "INSERT INTO ORDERS(ID, CODE, STATUS, USER_ID) VALUES(NULL, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "order Code");
            stmt.setString(2, "order Status");
            stmt.setInt(3, 1); //1 là id của user
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public boolean update() {
        String sql = "UPDATE ORDERS SET code = ?, status = ?, user_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "order Code");
            stmt.setString(2, "order Status");
            stmt.setInt(3, 1); //1 là id của user
            stmt.setInt(4, 2); //2 là id của order cần cập nhật
            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM ORDERS WHERE ID = ?";
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
        String sql = "SELECT * FROM ORDERS WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String code = rs.getString("code");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                System.out.format("%d:%s:%s:%d", id, code, status, userId).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void findAll() {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM ORDERS";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                //  Timestamp created_at = rs.getTimestamp("created_at");
                System.out.format("%d:%s:%s:%d", id, code, status, userId).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void findByUser(int userId) {
        String sql = "SELECT * FROM ORDERS WHERE user_id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String status = rs.getString("status");
                //  Timestamp createdAt = rs.getTimestamp("created_at");
                System.out.format("%d:%s:%s:%d", id, code, status, userId).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void findByStatus(String status) {
        try {
            String sql = "SELECT * FROM ORDERS WHERE STATUS = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                int userId = rs.getInt("user_id");
                //  Timestamp createdAt = rs.getTimestamp("created_at");
                System.out.format("%d:%s:%s:%d", id, code, status, userId).println();
            }
        } catch (SQLException ex) {
        }
    }

    public void findByCode(String code) {
        String sql = "SELECT * FROM ORDERS WHERE CODE= ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                //  Timestamp createdAt = rs.getTimestamp("created_at");
                System.out.format("%d:%s:%s:%d", id, code, status, userId).println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//	public int countOrderByDay(String date) {
//        int count = 0;
//        String sql = "SELECT COUNT(*) AS count FROM orders where date(created_at)=?";
//        try {
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setString(1, date);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                count = rs.getInt("count");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return count;
//    }
}
