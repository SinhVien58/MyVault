package SignUpAndLogIn;

import java.util.Scanner;

public class testSignUpAndLogIn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Dang ki
        System.out.print("\nNhap ho va ten: ");
        String fullName = scanner.nextLine();
        System.out.print("\nTai khoan: ");
        String regUsername = scanner.nextLine();
        System.out.print("\nMat khau: ");
        String regPassword = scanner.nextLine();
        System.out.print("\nSo dien thoai:");
        String regPhoneNumber = scanner.nextLine();
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
//        System.out.print("\nTai khoan: ");
//        String logUsername = scanner.nextLine();
//        System.out.print("\nMat khau: ");
//        String logPassword = scanner.nextLine();
//        LogIn.authenticateUser(logUsername, logPassword);

        // Close the scanner
        scanner.close();
    }
}
