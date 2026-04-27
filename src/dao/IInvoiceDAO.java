package dao;

import model.InvoiceDetail;
import java.util.List;

public interface IInvoiceDAO {
    void create(int customerId, List<InvoiceDetail> list);
}