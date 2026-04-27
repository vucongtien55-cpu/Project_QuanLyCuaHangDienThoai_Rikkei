package utils;

import java.util.Scanner;

public class InputUtil {

    private static Scanner sc=new Scanner(System.in);

    public static int inputInt(String msg){
        while(true){
            try{
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            }catch(Exception e){
                System.out.println("Nhap sai! Phai la so!");
            }
        }
    }

    public static double inputDouble(String msg){
        while(true){
            try{
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine());
            }catch(Exception e){
                System.out.println("Nhap sai! Phai la so!");
            }
        }
    }

    public static String inputString(String msg){
        while(true){
            System.out.print(msg);
            String s=sc.nextLine();
            if(!s.trim().isEmpty()) return s;

            System.out.println("Khong duoc de trong!");
        }
    }
}