package dao;

import model.Customer;
import java.util.List;

public interface ICustomerDAO {
    void insert(Customer c);
    List<Customer> findAll();
    void delete(int id);
}