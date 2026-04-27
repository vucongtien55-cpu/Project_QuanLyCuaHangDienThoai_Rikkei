package business;

import model.Customer;
import java.util.List;

public interface CustomerService {

    boolean add(Customer c);

    boolean update(Customer c);

    boolean delete(int id);

    List<Customer> getAll();

    Customer getById(int id);
}