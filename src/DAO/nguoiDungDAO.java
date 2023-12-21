package DAO;

import Database.JDBC_Util;
import Model.nguoiDung;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class nguoiDungDAO extends DAOInterface<nguoiDung> {
    public static nguoiDungDAO getInstance(){
        return new nguoiDungDAO();
    }
    @Override
    public int insert(nguoiDung nguoiDung) {
        int ketQua = 0;
        try {
        //tao ket noi den CSDL
        Connection con = JDBC_Util.getConnection();
        //tao doi tuong statement
            Statement st = con.createStatement();
        //thuc thi cau lenh SQL
        String sql = "INSERT INTO nguoi_dung (ID, HoVaTen, TaiKhoan, MatKhau, DienThoai, MaSoDinhDanh)"+
                    " VALUES ("+nguoiDung.getID()+", "+nguoiDung.getHoVaTen()+", '"+nguoiDung.getTaiKhoan()+"', '"+nguoiDung.getMatKhau()+"', '"+nguoiDung.getDienThoai()+"', '"+nguoiDung.getMaSoDinhDanh()+"')";

        ketQua = st.executeUpdate(sql);
        //xu li ket qua
            System.out.println(("Ban da thuc thi " + sql));
        System.out.println("Co "+ ketQua +" dong bi thay doi!");
        //ngat ket noi
        JDBC_Util.closeConnection(con);
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
    @Override
    public int update(nguoiDung nguoiDung) {
        int ketQua = 0;
        try {
            //tao ket noi den CSDL
            Connection con = JDBC_Util.getConnection();
            //tao doi tuong statement
            Statement st = con.createStatement();
            //thuc thi cau lenh SQL
            String sql = "UPDATE nguoi_dung"+
                        " SET "+
                        " ID = '" + nguoiDung.getID()+ "'"+
                        " Ho_va_Ten = '" + nguoiDung.getHoVaTen()+ "'"+
                        ", Tai_khoan = '" + nguoiDung.getTaiKhoan()+"'"+
                        ", Mat_khau = " + nguoiDung.getMatKhau()+
                        ", Gmail = '" + nguoiDung.getDienThoai()+ "'"+
                        " WHERE ID = '"+nguoiDung.getID()+ "'";
            System.out.println(sql);

            ketQua = st.executeUpdate(sql);
            //xu li ket qua
            System.out.println(("Ban da thuc thi " + sql));
            System.out.println("Co "+ ketQua +" dong bi thay doi!");
            //ngat ket noi
            JDBC_Util.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
    @Override
    public int delete(nguoiDung nguoiDung) {
        int ketQua = 0;
        try {
            //tao ket noi den CSDL
            Connection con = JDBC_Util.getConnection();
            //tao doi tuong statement
            Statement st = con.createStatement();
            //thuc thi cau lenh SQL
            String sql = "DELETE from nguoi_dung "+
                        " WHERE MaSoDinhDanh='"+nguoiDung.getMaSoDinhDanh()+"'";
            System.out.println(sql);

            ketQua = st.executeUpdate(sql);
            //xu li ket qua
            System.out.println(("Ban da thuc thi " + sql));
            System.out.println("Co "+ ketQua +" dong bi thay doi!");
            //ngat ket noi
            JDBC_Util.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
    @Override
    public ArrayList<nguoiDung> selectAll() {
        return null;
    }
    @Override
    public nguoiDung selectByTenRieng(nguoiDung nguoiDung, String n) {
        return null;
    }

    @Override
    public nguoiDung selectByKhuVuc(nguoiDung nguoiDung, String n) {
        return null;
    }

    @Override
    public nguoiDung selectByThoiGian(nguoiDung nguoiDung, String n, String m) {
        return null;
    }

    @Override
    public ArrayList<nguoiDung> selectByCondition(String condition) {
        return null;
    }
}
