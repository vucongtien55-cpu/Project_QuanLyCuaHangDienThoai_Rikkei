package business.impl;

import business.ProductService;
import dao.IProductDAO;
import dao.impl.ProductDAOImpl;
import model.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private IProductDAO dao = new ProductDAOImpl();

    public void add(Product p) {
        if (p.getName() == null || p.getName().trim().isEmpty()) {
            System.out.println("Tên sản phẩm không được để trống!");
            return;
        }
        if (p.getPrice() < 0) {
            System.out.println("Giá không hợp lệ!");
            return;
        }
        dao.insert(p);
    }

    public List<Product> getAll(){
        return dao.findAll();
    }

    public void delete(int id){
        dao.delete(id);
    }

    public void update(Product p){
        dao.update(p);
    }
}