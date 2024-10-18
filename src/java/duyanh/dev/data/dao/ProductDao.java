package duyanh.dev.data.dao;

import java.util.List;

import duyanh.dev.data.model.Category;
import duyanh.dev.data.model.Product;

public interface ProductDao {

    public boolean insert(Product product);

    public boolean update(Product product);

    public boolean delete(int id);

    public Product find(int id);

    public List<Product> findAll();

    public List<Product> hot(int limit);

    public List<Product> News(int limit);

    public List<Product> findByName(String productName);

    public List<Product> getProducts(int from ,int amount);

    public List<Product> filter(int categoryId, String propertyName, String order);

    public List<Product> findByCategory(int categoryId);
}
