package business.impl;

import business.InvoiceService;
import dao.IInvoiceDAO;
import dao.impl.InvoiceDAOImpl;
import model.InvoiceDetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceServiceImpl implements InvoiceService {

    private IInvoiceDAO dao=new InvoiceDAOImpl();

    public void create(int customerId, List<InvoiceDetail> list){

        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách sản phẩm không được trống!");
            return;
        }

        Map<Integer, InvoiceDetail> map = new HashMap<>();

        for(InvoiceDetail item : list){
            if(item.getQuantity() <= 0 || item.getPrice() <= 0){
                System.out.println("Du lieu khong hop le!");
                return;
            }

            int pid = item.getProductId();

            if(map.containsKey(pid)){
                InvoiceDetail old = map.get(pid);
                old.setQuantity(old.getQuantity() + item.getQuantity());
            } else {
                map.put(pid, item);
            }
        }

        List<InvoiceDetail> newList = new ArrayList<>(map.values());


        double total = 0;
        for(InvoiceDetail i : newList){
            total += i.getQuantity() * i.getPrice();
        }

        System.out.println("Tong tien hoa don: " + total);

        dao.create(customerId,newList);
    }

}