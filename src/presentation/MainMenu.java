package presentation;

import java.util.*;

public class MainMenu {

    private Scanner sc=new Scanner(System.in);

    public void menu(){
        while(true){
            System.out.println("\n=== MENU ===");
            System.out.println("1.Product");
            System.out.println("2.Customer");
            System.out.println("3.Invoice");
            System.out.println("0.Thoat");

            int c=sc.nextInt();

            switch(c){
                case 1 -> new ProductView().menu();
                case 2 -> new CustomerView().menu();
                case 3 -> new InvoiceView().menu();
                case 0 -> System.exit(0);
            }
        }
    }
}