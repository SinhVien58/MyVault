package SignUpAndLogIn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogIn {
    public static boolean authenticateUser(String username, String password) {
        //kiem tra xem tai khoan va mat khau co trong co so du lieu hay khong
        String authenticateQuery = "SELECT COUNT(*) FROM nguoi_dung WHERE TaiKhoan = ? AND MatKhau = ?";
        try (Connection connection = DriverManager.getConnection(SignUp.getDatabaseUrl(), SignUp.getUsername(), SignUp.getPassword());
             PreparedStatement statement = connection.prepareStatement(authenticateQuery)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    System.out.println("Chao mung " + username + " da quay lai voi ung dung!");
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Tai khoan hoac mat khau khong hop le. Vui long thu lai!");
        return false;
    }

        public static boolean authenticateAdmin(String username, String password) {
            //kiem tra xem tai khoan va mat khau co trong co so du lieu hay khong
            String authenticateQuery1 = "SELECT COUNT(*) FROM can_bo WHERE TaiKhoan = ? AND MatKhau = ?";
            try (Connection connection = DriverManager.getConnection(SignUp.getDatabaseUrl(), SignUp.getUsername(), SignUp.getPassword());
                 PreparedStatement statement = connection.prepareStatement(authenticateQuery1)) {
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    if (count > 0) {
                        System.out.println("Chao mung " + username + " da quay lai voi ung dung!");
                        return true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        //neu khong co, dang nhap that bai
        System.out.println("Tai khoan hoac mat khau khong hop le. Vui long thu lai!");
        return false;
    }
}