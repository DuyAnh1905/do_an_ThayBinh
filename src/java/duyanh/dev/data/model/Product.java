package duyanh.dev.data.model;

import duyanh.dev.data.dao.CategoryDao;
import duyanh.dev.data.dao.DatabaseDao;
import java.sql.Timestamp;

public class Product {

    public int id;
    public String name;
    public String description;
    public String thumbnail;
    public double price;
    public int quantity;
    public int categoryId; // Use camelCase consistently
    private int view;
    private Timestamp createdAt;

    public Product(int id, String name, String description, String thumbnail, double price, int quantity,
            int view, int categoryId, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.view = view;
        this.createdAt = createdAt;
    }

    public Product(String name, String description, String thumbnail, double price, int quantity,
            int view, int categoryId, Timestamp createdAt) {
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.view = view;
        this.createdAt = createdAt;
    }

    public Product(String name, String description, String thumbnail, double price, int quantity,int categoryId) {
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;

    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Category getCategory() {
        return DatabaseDao.getInstance().getCategoryDao().find(this.categoryId);
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
