package SignUpAndLogIn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SignUp {
    private static List<User> users = new ArrayList<>();
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/app_quan_ly_thien_tai";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static boolean registerUser(String fullname,String username, String password, String phonenumber) {
        //kiem tra tai khoan da ton tai hay chua
        if (isUsernameTaken(username)) {
            System.out.println("Tai khoan nay da ton tai!");
            return false;
        }

        //thuc hien lenh sql
        String insertUserQuery = "INSERT INTO nguoi_dung (HoVaTen,TaiKhoan, MatKhau, SoDienThoai) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(insertUserQuery)) {
            statement.setString(1, fullname);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, phonenumber);
            statement.executeUpdate();
            System.out.println("Dang ki thanh cong!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean registerAdmin(String fullname,String username, String password, String phonenumber, String idennum) {
        //kiem tra xem tai khoan da ton tai hay chua
        if (isAdminNameTaken(username)) {
            System.out.println("Tai khoan nay da ton tai!");
            return false;
        }
        //kiem tra tinh hop le cua ma so dinh danh
        if (!isIdenNumValid(idennum)) {
            System.out.println("Ma so dinh danh khong hop le!");
            return false;
        }
        // If the username is not taken, create a new user and add it to the database
        String sql = "UPDATE can_bo"+
                " SET "+
                " HoVaTen = ?"+
                ", TaiKhoan = ?"+
                ", MatKhau = ?"+
                ", DienThoai = ?"+
                " WHERE MaSoDinhDanh = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, fullname);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, phonenumber);
            statement.setString(5, idennum);
            statement.executeUpdate();
            System.out.println("Dang ki thanh cong!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isUsernameTaken(String username) {
        String checkUsernameQuery = "SELECT COUNT(*) FROM nguoi_dung WHERE TaiKhoan = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(checkUsernameQuery)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isAdminNameTaken(String username) {
        String checkUsernameQuery = "SELECT COUNT(*) FROM can_bo WHERE TaiKhoan = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(checkUsernameQuery)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isIdenNumValid(String masodinhdanh) {
        // Check if the identification code is available in the 'admin' database
        String checkCodeQuery = "SELECT COUNT(*) FROM can_bo WHERE MaSoDinhDanh = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(checkCodeQuery)) {
            statement.setString(1, masodinhdanh);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static String getDatabaseUrl() {
        return DATABASE_URL;
    }
    public static String getUsername() {
        return USERNAME;
    }
    public static String getPassword() {
        return PASSWORD;
    }
}