package business.impl;

import business.CustomerService;
import dao.ICustomerDAO;
import dao.impl.CustomerDAOImpl;
import model.Customer;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private final ICustomerDAO dao = new CustomerDAOImpl();

    @Override
    public boolean add(Customer c) {
        if (c == null || c.getName() == null || c.getName().trim().isEmpty()) {
            return false;
        }
        try {
            dao.insert(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Customer c) {
        if (c == null || c.getId() <= 0) return false;
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Customer> getAll() {
        return dao.findAll();
    }

    @Override
    public Customer getById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        if (id <= 0) return false;
        try {
            dao.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}