package duyanh.dev.data.model;

import java.sql.Timestamp;

import duyanh.dev.data.dao.DatabaseDao;

public class OrderItem {

    public int id;
    public int order_id;
    public int product_id;
    public double price;
    public int quantity;
    public Timestamp created_at;

    public OrderItem(int quantity, double price, int orderId, int productId) {
        this.quantity = quantity;
        this.price = price;
        this.order_id = orderId;
        this.product_id = productId;
    }

    public OrderItem(int id, int quantity, double price, int orderId, int productId) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.order_id = orderId;
        this.product_id = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrderId() {
        return order_id;
    }

    public void setOrderId(int orderId) {
        this.order_id = orderId;
    }

    public int getProductId() {
        return product_id;
    }

    public void setProductId(int productId) {
        this.product_id = productId;
    }

    public Product getProduct(){
        return DatabaseDao.getInstance().getProductDao().find(this.product_id);
    }

    public Order getOrder() {
        return DatabaseDao.getInstance().getOrderDao().find(this.order_id);
    }

   
}
