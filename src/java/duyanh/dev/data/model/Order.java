package duyanh.dev.data.model;

import duyanh.dev.data.dao.DatabaseDao;
import java.security.Timestamp;

public class Order {

    public int id;
    public String code;
    public String status;
    public int user_id;
    public Timestamp created_at;

    public Order(int id, String code, String status, int user_id) {
        super();
        this.id = id;
        this.code = code;
        this.status = status;
        this.user_id = user_id;
    }

    public Order(String code, String status, int user_id) {
        super();

        this.code = code;
        this.status = status;
        this.user_id = user_id;
    }

    public Order(int id, String code, String status, int userId, Timestamp createdAt) {
        super();
        this.id = id;
        this.code = code;
        this.status = status;
        this.user_id = userId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }

    public User getUser() {
        return DatabaseDao.getInstance().getUserDao().find(this.user_id);
    }
}
