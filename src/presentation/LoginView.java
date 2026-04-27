package presentation;

import dao.IAdminDAO;
import dao.impl.AdminDAOImpl;
import model.Admin;

import java.util.Scanner;

public class LoginView {

    private Scanner sc = new Scanner(System.in);
    private IAdminDAO dao = new AdminDAOImpl();

    public void login(){

        while(true){
            System.out.print("Username: ");
            String u = sc.nextLine();

            System.out.print("Password: ");
            String p = sc.nextLine();

            Admin admin = dao.login(u, p);

            if(admin != null){
                System.out.println("Dang nhap thanh cong! Xin chao " + admin.getUsername());
                return;
            }else{
                System.out.println("Sai tai khoan hoac mat khau!");
            }
        }
    }
}