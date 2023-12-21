package Test;

import DAO.thienTaiDAO;
import Model.thienTai;

import java.util.Scanner;

public class testThienTaiDAO {
    public static void main(String[] agrs) {
        Scanner scanner = new Scanner(System.in);
        thienTai thienTai1 = new thienTai();
//
//        System.out.print("ID: ");
//        String ID = scanner.nextLine();
//
//        System.out.print("LoaiThienTai: ");
//        String loaiThienTai = scanner.nextLine();
//
//        System.out.print("TenRieng: ");
//        String tenRieng = scanner.nextLine();
//
//        System.out.print("KhuVuc: ");
//        String khuVuc = scanner.nextLine();
//
//        System.out.print("ThoiGian: ");
//        String thoiGian = scanner.nextLine();
//
//        System.out.print("MucDo: ");
//        int mucDo = scanner.nextInt();
//        thienTai thienTai2 = new thienTai(ID, loaiThienTai, tenRieng, khuVuc, thoiGian, mucDo);
//        thienTaiDAO.getInstance().insert(thienTai2);

        int luaChon;
        do {
            System.out.print("Ban muon tim kiem theo thong tin nao(0: Theo ten rieng, 1: Theo khu vuc, 2: Theo thoi gian, khac: Thoat chuc nang): ");
            luaChon = scanner.nextInt();
            switch (luaChon) {
                case 0:
                    scanner.nextLine();
                    System.out.print("Nhap ten thien tai muon tim: ");
                    String ttt = scanner.nextLine();
                    thienTai1.setTenRieng(ttt);
                    System.out.println();
                    thienTaiDAO.getInstance().selectByTenRieng(thienTai1, ttt);
                    break;
                case 1:
                    scanner.nextLine();
                    System.out.print("Nhap khu vuc muon tim: ");
                    String kv = scanner.nextLine();
                    thienTai1.setKhuVuc(kv);
                    System.out.println();
                    thienTaiDAO.getInstance().selectByKhuVuc(thienTai1, kv);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Nhap khoang thoi gian muon tim: ");
                    System.out.print("\nTu (Nhap theo dang YYYY-MM-DD): ");
                    String tu = scanner.nextLine();
                    System.out.print("Den (Nhap theo dang YYYY-MM-DD): ");
                    String den = scanner.nextLine();
                    thienTaiDAO.getInstance().selectByThoiGian(thienTai1, tu, den);
                    break;
                default:
                    System.out.println("Thoat chuc nang!");
                    break;
            }
        } while (luaChon == 0 || luaChon == 1 || luaChon == 2);
//        String ltt = scanner.nextLine();
//        thienTai1.setLoaiThienTai(ltt);
//        thienTaiDAO.getInstance().selectById(thienTai1, ltt);

    }
}
