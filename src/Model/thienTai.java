package Model;

public class thienTai {
    private String Prefix;
    private String LoaiThienTai;
    private String TenRieng;
    private String KhuVuc;
    private String ThoiGian;
    private int MucDo;
    public thienTai() {
    }

    public thienTai(String prefix,String loaiThienTai, String tenRieng, String khuVuc, String thoiGian, int mucDo) {
        Prefix = prefix;
        LoaiThienTai = loaiThienTai;
        TenRieng = tenRieng;
        KhuVuc = khuVuc;
        ThoiGian = thoiGian;
        MucDo = mucDo;
    }
    public String getPrefix(){ return Prefix; }
    public void setPrefix(String prefix){ Prefix = prefix; }
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
