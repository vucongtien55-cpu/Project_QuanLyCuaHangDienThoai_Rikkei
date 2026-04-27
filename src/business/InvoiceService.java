package business;

import model.InvoiceDetail;
import java.util.List;

public interface InvoiceService {
    void create(int customerId, List<InvoiceDetail> list);
}