package business.impl;

import business.InvoiceService;
import dao.IInvoiceDAO;
import dao.impl.InvoiceDAOImpl;
import model.InvoiceDetail;

import java.util.List;

public class InvoiceServiceImpl implements InvoiceService {

    private IInvoiceDAO dao=new InvoiceDAOImpl();

    public void create(int customerId, List<InvoiceDetail> list){
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách sản phẩm không được trống!");
            return;
        }
        dao.create(customerId,list);
    }
}