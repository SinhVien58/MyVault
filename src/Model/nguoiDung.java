package Model;

public class nguoiDung {
    private String ID;
    private String HoVaTen;
    private String TaiKhoan;
    private String MatKhau;
    private String DienThoai;
    private String MaSoDinhDanh;
    public nguoiDung() {
    }

    public nguoiDung(String id, String hoVaTen, String taiKhoan, String matKhau, String dienThoai, String maSoDinhDanh) {
        ID = id;
        HoVaTen = hoVaTen;
        TaiKhoan = taiKhoan;
        MatKhau = matKhau;
        DienThoai = dienThoai;
        MaSoDinhDanh = maSoDinhDanh;
    }
    public String getID() { return ID; }
    public void setID(String id) { ID = id; }
    public String getHoVaTen() {
        return HoVaTen;
    }
    public void setHoVaTen(String hoVaTen) {
        HoVaTen = hoVaTen;
    }
    public String getTaiKhoan() {
        return TaiKhoan;
    }
    public void setTaiKhoan(String taiKhoan) {
        TaiKhoan = taiKhoan;
    }
    public String getMatKhau() {
        return MatKhau;
    }
    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }
    public String getDienThoai() {
        return DienThoai;
    }
    public void setDienThoai(String dienThoai) {
        DienThoai = dienThoai;
    }
    public String getMaSoDinhDanh() {
        return MaSoDinhDanh;
    }
    public void setMaSoDinhDanh(String maSoDinhDanh) {
        MaSoDinhDanh = maSoDinhDanh;
    }
}
