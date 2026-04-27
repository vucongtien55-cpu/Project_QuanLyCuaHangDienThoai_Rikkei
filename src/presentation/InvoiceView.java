package presentation;

import business.InvoiceService;
import business.impl.InvoiceServiceImpl;
import model.InvoiceDetail;

import java.util.*;

public class InvoiceView {

    private Scanner sc=new Scanner(System.in);
    private InvoiceService service=new InvoiceServiceImpl();

    public void menu(){

        System.out.print("Nhap Customer ID: ");
        int cusId=sc.nextInt();

        List<InvoiceDetail> list=new ArrayList<>();

        while(true){
            System.out.print("Product ID: ");
            int pid=sc.nextInt();

            System.out.print("So luong: ");
            int qty=sc.nextInt();

            System.out.print("Gia: ");
            double price=sc.nextDouble();

            list.add(new InvoiceDetail(pid,qty,price));

            System.out.print("Them tiep? (y/n): ");
            String c=sc.next();

            if(c.equalsIgnoreCase("n")) break;
        }

        service.create(cusId,list);
    }
}