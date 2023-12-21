package Model;

public class thienTai {
    private String ID;
    private String LoaiThienTai;
    private String TenRieng;
    private String KhuVuc;
    private String ThoiGian;
    private int MucDo;
    public thienTai() {
    }

    public thienTai(String id, String loaiThienTai, String tenRieng, String khuVuc, String thoiGian, int mucDo) {
        ID = id;
        LoaiThienTai = loaiThienTai;
        TenRieng = tenRieng;
        KhuVuc = khuVuc;
        ThoiGian = thoiGian;
        MucDo = mucDo;
    }
    public String getID(){ return ID; }
    public void setID(String id){ ID = id; }
    public String getLoaiThienTai() {
        return LoaiThienTai;
    }
    public void setLoaiThienTai(String loaiThienTai) {
        LoaiThienTai = loaiThienTai;
    }
    public String getTenRieng() {
        return TenRieng;
    }
    public void setTenRieng(String tenRieng) {
        TenRieng = tenRieng;
    }
    public String getKhuVuc() {
        return KhuVuc;
    }
    public void setKhuVuc(String khuVuc) {
        KhuVuc = khuVuc;
    }
    public String getThoiGian() {
        return ThoiGian;
    }
    public void setThoiGian(String thoiGian) {
        ThoiGian = thoiGian;
    }
    public int getMucDo() {
        return MucDo;
    }
    public void setMucDo(int mucDo) {
        MucDo = mucDo;
    }
}
