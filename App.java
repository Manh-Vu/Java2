import dao.studentDAO;
import model.Students;

import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner in= new Scanner(System.in);
    private static studentDAO stDAO = new studentDAO();
    private static void mainMenu() {
        System.out.println("--------QUAN LY THONG TIN SINH VIEN--------");
        System.out.println("1. Danh sách sinh viên");
        System.out.println("2. Nhập thông tin sinh viên");
        System.out.println("3. Xóa sinh viên theo mã");
        System.out.println("4. Cập nhật thông tin sinh viên");
        System.out.println("5. Tìm sinh vien theo họ tên hoặc mã");
        System.out.println("6. Sắp xếp sinh viên theo GPA tng dần");
        System.out.println("7. In ra danh sách sinh vien nữ ở Hà Nội và GPA >2.5");
        System.out.println("8. Sắp xếp sinh viên theo họ tên");
        System.out.println("0. Thoát khỏi chương trình");
    }
    private static void option1(){
        List<Students> studentList = stDAO.getAll();
        System.out.printf("%-20s %-30s %-20s %-20s", "Mã SV", "Họ tên", "Giới tính", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {
            Students s = studentList.get(i);
            System.out.printf("%-20s %-30s %-20d %-20s\n", s.getId(), s.getFull_name(), s.getGender(),s.getAddress());
        }


    }

    private static void option2(){
       // Students s = new Students("BKC4","Nguyen van A",0,"10/2/1998","Hà Nôi","bkc4@gmail.com","12325289",9.0);

        Students s1 = new Students();
        System.out.print("\tNhập id: ");
        s1.setId(in.nextLine());
        System.out.print("\tNhập Họ tên: ");
        s1.setFull_name(in.nextLine());
        System.out.print("\tNhập giới tính: ");
        s1.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("\tNhập năm sinh: ");
        s1.setYear(in.nextLine());
        System.out.print("\tNhập địa chỉ: ");
        s1.setAddress(in.nextLine());
        System.out.print("\tNhập email: ");
        s1.setEmail(in.nextLine());
        System.out.print("\tNhập số điện thoại: ");
        s1.setPhone(in.nextLine());
        System.out.print("\tNhập GPA: ");
        s1.setGpa(Double.parseDouble(in.nextLine()));


        stDAO.insert(s1);
    }

    private static void option3(){
        System.out.println("Nhập id muốn xóa");
        String id=in.nextLine();
        stDAO.delete(id);
    }

    private static void option4(){
        //Students s = new Students("BKC1","Nguyen van A",0,"10/2/1998","Hà Nôi","bkc1@gmail.com","123456789",8.5);
        Students s= new Students();
        System.out.print("\tNhập id: ");
        String id=in.nextLine();
        System.out.print("\tNhập Họ tên: ");
        s.setFull_name(in.nextLine());
        System.out.print("\tNhập giới tính: ");
        s.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("\tNhập năm sinh: ");
        s.setYear(in.nextLine());
        System.out.print("\tNhập địa chỉ: ");
        s.setAddress(in.nextLine());
        System.out.print("\tNhập email: ");
        s.setEmail(in.nextLine());
        System.out.print("\tNhập số điện thoại: ");
        s.setPhone(in.nextLine());
        System.out.print("\tNhập GPA: ");
        s.setGpa(Double.parseDouble(in.nextLine()));


        stDAO.update(s,id);
    }
    private static void option5() {
        System.out.println("Nhập mã hoặc tên");
        String stsearch=in.nextLine();
        Students s = stDAO.Search(stsearch);
        System.out.printf("%-20s %-30s %-20s %-20s", "Mã SV", "Họ tên", "Giới tính", "Địa chỉ");
        System.out.println();


            System.out.printf("%-20s %-30s %-20d %-20s\n", s.getId(), s.getFull_name(), s.getGender(), s.getAddress());

    }

    private static void option6() {
        List<Students> studentList = stDAO.getAll();
        studentList.stream().sorted();
        System.out.printf("%-20s %-30s %-20s %-20s", "Mã SV", "Họ tên", "Giới tính", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {
            Students s = studentList.get(i);
            System.out.printf("%-20s %-30s %-20d %-20s\n", s.getId(), s.getFull_name(), s.getGender(),s.getAddress());
        }

    }

    private static void option7() {
        List<Students> studentList = stDAO.getAll();
        System.out.printf("%-20s %-30s %-20s %-20s", "Mã SV", "Họ tên", "Giới tính", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {

            Students s = studentList.get(i);
            if (s.getGpa()>2.5 && s.getAddress().equals("Hà Nội") && s.getGender()==0 ) {


                System.out.printf("%-20s %-30s %-20d %-20s\n", s.getId(), s.getFull_name(), s.getGender(), s.getAddress());
            }
        }

    }
    private static void option8(){
        List<Students> studentList = stDAO.sort();
        System.out.printf("%-20s %-30s %-20s %-20s", "Mã SV", "Họ tên", "Giới tính", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {
            Students s = studentList.get(i);
            System.out.printf("%-20s %-30s %-20d %-20s\n", s.getId(), s.getFull_name(), s.getGender(),s.getAddress());
        }


    }

    public static void main(String[] args) {
        int option =-1;

        do {
            mainMenu();
            System.out.println("Nhập lựa chọn");
            try {
                option = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập sai định dạng");
                continue;
            }
            if (option < 1 || option > 8) {
                System.out.println("Lựa chọn không hợp lệ!");
                continue;
            }
            switch (option){
                case 1:
                    option1();
                    break;
                case 2:
                    option2();
                    break;
                case 3:
                    option3();
                    break;
                case 4:
                    option4();
                    break;
                case 5:
                    option5();
                    break;

                case 6:
                    option6();
                    break;
                case 7:
                    option7();
                    break;
                case 8:
                    option8();
                    break;
            }

        }while (option!=0);
    }
}
