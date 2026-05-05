package presentation;

import business.InvoiceService;
import business.impl.InvoiceServiceImpl;
import model.InvoiceDetail;

import java.util.*;

public class InvoiceView {

    private Scanner sc=new Scanner(System.in);
    private InvoiceService service=new InvoiceServiceImpl();

    public void menu(){
        int cusId;

        while(true){
            try{
                System.out.print("Nhap Customer ID: ");
                cusId = Integer.parseInt(sc.nextLine());
                if(cusId <= 0) throw new Exception();
                break;
            }catch(Exception e){
                System.out.println("ID khong hop le!");
            }
        }

        List<InvoiceDetail> list=new ArrayList<>();

        while(true){
            try{
                System.out.print("Product ID: ");
                int pid = Integer.parseInt(sc.nextLine());

                System.out.print("So luong: ");
                int qty = Integer.parseInt(sc.nextLine());

                System.out.print("Gia: ");
                double price = Double.parseDouble(sc.nextLine());

                if(qty <= 0 || price <= 0){
                    System.out.println("Du lieu khong hop le!");
                    continue;
                }

                list.add(new InvoiceDetail(pid,qty,price));

                System.out.print("Them tiep: (yes/no): ");
                String c=sc.nextLine();

                if(c.equalsIgnoreCase("no")) break;

            }catch(Exception e){
                System.out.println("Nhap sai dinh dang!");
            }
        }

        service.create(cusId,list);
    }
}
//nhập dữ liệu hóa đơn từ người dùng và gửi sang tầng xử lý (business).
//gửi sang InvoiceService để tạo hóa đơn mới với thông tin khách hàng và chi tiết hóa đơn.