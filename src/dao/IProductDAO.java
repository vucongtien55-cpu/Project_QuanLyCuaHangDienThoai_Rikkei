package dao;

import model.Product;
import java.util.List;

public interface IProductDAO {
    void insert(Product p);
    List<Product> findAll();
    Product findById(int id);
    void update(Product p);
    void delete(int id);
}