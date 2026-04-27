package presentation;

import business.CustomerService;
import business.impl.CustomerServiceImpl;
import model.Customer;
import java.util.Scanner;

public class CustomerView {
    private Scanner sc = new Scanner(System.in);
    private CustomerService service = new CustomerServiceImpl();

    public void menu() {
        while (true) {
            System.out.println("\n=== QUẢN LÝ KHÁCH HÀNG ===");
            System.out.println("1. Danh sách khách hàng");
            System.out.println("2. Thêm khách hàng mới");
            System.out.println("3. Xóa khách hàng");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");

            String choice = sc.next();
            switch (choice) {
                case "1" -> service.getAll().forEach(System.out::println);
                case "2" -> add();
                case "3" -> delete();
                case "0" -> { return; }
                default -> System.out.println("Chọn không hợp lệ!");
            }
        }
    }

    private void add() {
        sc.nextLine();
        System.out.print("Tên: "); String name = sc.nextLine();
        System.out.print("SĐT: "); String phone = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Địa chỉ: "); String address = sc.nextLine();

        boolean success = service.add(new Customer(name, phone, email, address));
        if (success) {
            System.out.println(" THÀNH CÔNG: Đã thêm khách hàng.");
        } else {
            System.out.println(" THẤT BẠI: Vui lòng kiểm tra lại dữ liệu.");
        }
    }

    private void delete() {
        System.out.print("Nhập ID cần xóa: ");
        int id = sc.nextInt();
        if (service.delete(id)) {
            System.out.println(" THÀNH CÔNG: Đã xóa khách hàng.");
        } else {
            System.out.println(" THẤT BẠI: Không tìm thấy ID hoặc lỗi kết nối.");
        }
    }
}