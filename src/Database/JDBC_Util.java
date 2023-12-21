package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Util {
    public static Connection getConnection(){
        Connection c = null;

        try {
            // dang ky MySQL voi drive manager
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            // cac thong so
            String url = "jdbc:mySQL://localhost:3306/app_quan_ly_thien_tai";
            String username = "root";
            String password = "";
            // tao ket noi
            c = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return c;
    }

    public static void closeConnection(Connection c){
        try{
            if(c!=null){
                c.close();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
