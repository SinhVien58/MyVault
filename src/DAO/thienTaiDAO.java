package DAO;

import Database.JDBC_Util;
import Model.thienTai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class thienTaiDAO extends DAOInterface<thienTai>{
    public static thienTaiDAO getInstance(){
        return new thienTaiDAO();
    }
    @Override
    public int insert(thienTai thienTai) {
        int ketQua = 0;
        try {
            //tao ket noi den CSDL
            Connection con = JDBC_Util.getConnection();
            //tao doi tuong statement
            String sql = "INSERT INTO thien_tai (MaThienTai, LoaiThienTai, TenRieng, KhuVuc, ThoiGian, MucDo)"+
                    " VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            //thuc thi cau lenh SQL
            pst.setString(1, thienTai.getPrefix());
            pst.setString(2, thienTai.getLoaiThienTai());
            pst.setString(3, thienTai.getTenRieng());
            pst.setString(4, thienTai.getKhuVuc());
            pst.setString(5, thienTai.getThoiGian());
            pst.setInt(6, thienTai.getMucDo());
//            generateAndPrintID();
            ketQua = pst.executeUpdate();
            //xu li ket qua
            System.out.println(("Them thong tin thien tai thanh cong!"));
//            System.out.println("Co "+ ketQua +" dong bi thay doi!");
            //ngat ket noi
            JDBC_Util.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
    @Override
    public int update(thienTai thienTai) {
        int ketQua = 0;
        try {
            //tao ket noi den CSDL
            Connection con = JDBC_Util.getConnection();
            //tao doi tuong statement
            String sql = "UPDATE thien_tai"+
                    " SET "+
                    " LoaiThienTai = ?"+
                    ", TenRieng = ?"+
                    ", KhuVuc = ?"+
                    ", ThoiGian = ?"+
                    ", MucDo = ?"+
                    " WHERE ID = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            //thuc thi cau lenh SQL
            pst.setString(1, thienTai.getLoaiThienTai());
            pst.setString(2, thienTai.getTenRieng());
            pst.setString(3, thienTai.getKhuVuc());
            pst.setString(4, thienTai.getThoiGian());
            pst.setInt(5, thienTai.getMucDo());
            pst.setString(6, thienTai.getPrefix());
            System.out.println(sql);

            ketQua = pst.executeUpdate();
            //xu li ket qua
//            System.out.println(("Ban da thuc thi " + sql));
//            System.out.println("Co "+ ketQua +" dong bi thay doi!");
            //ngat ket noi
            JDBC_Util.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
    @Override
    public int delete(thienTai thienTai) {
        int ketQua = 0;
        try {
            //tao ket noi den CSDL
            Connection con = JDBC_Util.getConnection();
            //tao doi tuong statement
            String sql = "DELETE from thien_tai "+
                    " WHERE ID=?";
            PreparedStatement pst = con.prepareStatement(sql);
            //thuc thi cau lenh SQL
            pst.setString(1, thienTai.getPrefix());
            System.out.println(sql);

            ketQua = pst.executeUpdate(sql);
            //xu li ket qua
//            System.out.println(("Ban da thuc thi " + sql));
//            System.out.println("Co "+ ketQua +" dong bi thay doi!");
            //ngat ket noi
            JDBC_Util.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
    @Override
    public ArrayList<thienTai> selectAll() {
        return null;
    }
    @Override
    public thienTai selectByTenRieng(thienTai t, String tr1) {
        thienTai ketQua = null;
        try {
            //tao ket noi den CSDL
            Connection con = JDBC_Util.getConnection();
            //tao doi tuong statement
            String sql = "SELECT * FROM thien_tai where TenRieng=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            //thuc thi cau lenh SQL
            pst.setString(1, tr1);
//            System.out.println("SQL Query: " + sql);
            ResultSet rs = pst.executeQuery();
            //in thong tin ra man hinh
            while(rs.next()){
                String prefix = rs.getString("MaThienTai");
                String id = rs.getString( "ID");
                String ltt = rs.getString("LoaiThienTai");
                String tr = rs.getString("TenRieng");
                String kv = rs.getString("KhuVuc");
                String tg = rs.getString("ThoiGian");
                int md = rs.getInt("MucDo");

                System.out.println("LoaiThienTai: " + ltt + " \nTenRieng: " + tr +
                        " \nKhuVuc: " + kv + " \nThoiGian: " + tg + " \nMucDo: " + md);

                ketQua = new thienTai(id, ltt, tr, kv, tg, md);
            }
            //ngat ket noi
            JDBC_Util.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
    @Override
    public thienTai selectByKieuThienTai(thienTai t, String ktt) {
        thienTai ketQua = null;
        try {
            //tao ket noi den CSDL
            Connection con = JDBC_Util.getConnection();
            //tao doi tuong statement
                String sql = "SELECT * FROM thien_tai where MaThienTai=? ";
                PreparedStatement pst = con.prepareStatement(sql);
                //thuc thi cau lenh SQL
                if(Objects.equals(ktt, "Lu lut")) pst.setString(1, "LL");
                if(Objects.equals(ktt, "Sat lo")) pst.setString(1, "SL");
                if(Objects.equals(ktt, "Bao")) pst.setString(1, "B");
//            System.out.println("SQL Query: " + sql);
                ResultSet rs = pst.executeQuery();
                //in thong tin ra man hinh
                while (rs.next()) {
                    String prefix = rs.getString("MaThienTai");
                    String id = rs.getString("ID");
                    String ltt = rs.getString("LoaiThienTai");
                    String tr = rs.getString("TenRieng");
                    String kv = rs.getString("KhuVuc");
                    String tg = rs.getString("ThoiGian");
                    int md = rs.getInt("MucDo");

                    System.out.println("LoaiThienTai: " + ltt + " \nTenRieng: " + tr +
                            " \nKhuVuc: " + kv + " \nThoiGian: " + tg + " \nMucDo: " + md);

                    ketQua = new thienTai(id, ltt, tr, kv, tg, md);
                }
                //ngat ket noi
                JDBC_Util.closeConnection(con);
            } catch(SQLException e){
                throw new RuntimeException(e);
            }
            return ketQua;
    }

    @Override
    public thienTai selectByKhuVuc(thienTai thienTai, String kv1) {
        thienTai ketQua = null;
        try {
            //tao ket noi den CSDL
            Connection con = JDBC_Util.getConnection();
            //tao doi tuong statement
            String sql = "SELECT * FROM thien_tai where KhuVuc=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            //thuc thi cau lenh SQL
            pst.setString(1, kv1);
//            System.out.println("SQL Query: " + sql);
            ResultSet rs = pst.executeQuery();
            //in thong tin ra man hinh
            while(rs.next()){
                String id = rs.getString("MaThienTai");
                String ltt = rs.getString("LoaiThienTai");
                String tr = rs.getString("TenRieng");
                String kv = rs.getString("KhuVuc");
                String tg = rs.getString("ThoiGian");
                int md = rs.getInt("MucDo");

                System.out.println(" \nLoaiThienTai: " + ltt + " \nTenRieng: " + tr +
                        " \nKhuVuc: " + kv + " \nThoiGian: " + tg + " \nMucDo: " + md);

                ketQua = new thienTai(id, ltt, tr, kv, tg, md);
            }
            //ngat ket noi
            JDBC_Util.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public thienTai selectByThoiGian(thienTai thienTai, String n, String m) {
        thienTai ketQua = null;
        try {
            //tao ket noi den CSDL
            Connection con = JDBC_Util.getConnection();
            //tao doi tuong statement
            String sql = "SELECT * FROM thien_tai WHERE ThoiGian BETWEEN ? AND ?";
            PreparedStatement pst = con.prepareStatement(sql);
            //thuc thi cau lenh SQL
            pst.setString(1, n);
            pst.setString(2, m);
            ResultSet rs = pst.executeQuery();
            //in thong tin ra man hinh
            while(rs.next()){
                String id = rs.getString("MaThienTai");
                String ltt = rs.getString("LoaiThienTai");
                String tr = rs.getString("TenRieng");
                String kv = rs.getString("KhuVuc");
                String tg = rs.getString("ThoiGian");
                int md = rs.getInt("MucDo");

                System.out.println(" \nLoaiThienTai: " + ltt + " \nTenRieng: " + tr +
                        " \nKhuVuc: " + kv + " \nThoiGian: " + tg + " \nMucDo: " + md);

                ketQua = new thienTai(id, ltt, tr, kv, tg, md);
            }
            //ngat ket noi
            JDBC_Util.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    @Override
    public ArrayList<thienTai> selectByCondition(String condition) {
        return null;
    }
}
