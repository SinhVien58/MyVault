package SignUpAndLogIn;

import java.util.Scanner;

public class testSignUpAndLogIn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regPhoneNumber;
        String regPassword;
        String regPassword1;

        //Dang ki
        System.out.print("\nNhap ho va ten: ");
        String fullName = scanner.nextLine();
        System.out.print("\nTai khoan: ");
        String regUsername = scanner.nextLine();
        do {
            System.out.print("\nMat khau: ");
            regPassword = scanner.nextLine();
            if(regPassword.length() < 8) System.out.println("Mat khau can co tu 8 ki tu tro len! Vui long nhap lai:");
        }while(regPassword.length() < 8);
        do{
            System.out.print("\nNhap lai mat khau: ");
            regPassword1 = scanner.nextLine();
            if(!regPassword.equals(regPassword1)) System.out.print(("\nMat khau nhap lai chua dung! Vui long nhap lai:"));
        }while(!regPassword.equals(regPassword1));
        do {
            System.out.print("\nSo dien thoai:");
            regPhoneNumber = scanner.nextLine();
            if(regPhoneNumber.length() < 10) System.out.println("So dien thoai can co 10 chu so! Vui long nhap lai:");
        }while(regPhoneNumber.length() < 10);
        int choice;
        do {
            System.out.print("\nChon vai tro cua ban(0: Nguoi dan, 1: Can bo): ");
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    SignUp.registerUser(fullName, regUsername, regPassword, regPhoneNumber);
                    break;
                case 1:
                    System.out.print("Nhap ma so dinh danh: ");
                    scanner.nextLine();
                    String idenNum = scanner.nextLine();
                    SignUp.registerAdmin(fullName, regUsername, regPassword, regPhoneNumber, idenNum);
                    break;
                default:
                    System.out.println("Vui long chon 0 hoac 1!");
                    break;
            }
        } while (choice != 0 && choice != 1);

        //Dang nhap
//        System.out.print("Chon vai tro(0: Nguoi dan, 1: Can bo): ");
//        int vaitro = scanner.nextInt();
//        switch (vaitro) {
//            case 0:
//                scanner.nextLine();
//                System.out.print("\nTai khoan: ");
//                String logUsername = scanner.nextLine();
//                System.out.print("\nMat khau: ");
//                String logPassword = scanner.nextLine();
//                LogIn.authenticateUser(logUsername, logPassword);
//                break;
//            case 1:
//                scanner.nextLine();
//                System.out.print("\nTai khoan: ");
//                String logUsername1 = scanner.nextLine();
//                System.out.print("\nMat khau: ");
//                String logPassword1 = scanner.nextLine();
//                LogIn.authenticateAdmin(logUsername1, logPassword1);
//                break;
//            default:
//                System.out.println("Thoat chuong trinh!");
//                break;
//        }

        // Close the scanner
        scanner.close();
    }
}
