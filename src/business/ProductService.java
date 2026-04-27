package business;

import model.Product;
import java.util.List;

public interface ProductService {
    void add(Product p);
    List<Product> getAll();
    void delete(int id);
    void update(Product p);
}