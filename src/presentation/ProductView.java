package presentation;

import business.ProductService;
import business.impl.ProductServiceImpl;
import model.Product;
import utils.InputUtil;

import java.util.*;

public class ProductView {

    private Scanner sc=new Scanner(System.in);
    private ProductService service=new ProductServiceImpl();

    public void menu(){
        while(true){
            System.out.println("\n1.Danh sach");
            System.out.println("2.Them");
            System.out.println("3.Xoa");
            System.out.println("4.Sua");
            System.out.println("0.Thoat");

            int c=sc.nextInt();

            switch(c){
                case 1 -> service.getAll().forEach(System.out::println);
                case 2 -> add();
                case 3 -> delete();
                case 4 -> update();
                case 0 -> {return;}
            }
        }
    }

    private void add(){
        sc.nextLine();
        String name = InputUtil.inputString("Ten: ");
        String brand = InputUtil.inputString("Brand: ");
        double price = InputUtil.inputDouble("Gia: ");
        int stock = InputUtil.inputInt("Stock: ");

        Product p = new Product(name, brand, price, stock);
        service.add(p);
    }

    private void delete(){
        System.out.print("ID: ");
        service.delete(sc.nextInt());
    }

    private void update(){
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            String name = InputUtil.inputString("Ten moi: ");
            String brand = InputUtil.inputString("Brand: ");
            double price = InputUtil.inputDouble("Gia: ");
            int stock = InputUtil.inputInt("Stock: ");

            Product p = new Product(id, name, brand, price, stock);
            service.update(p);
    }
}