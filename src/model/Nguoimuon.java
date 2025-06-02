package model;

public class Nguoimuon {
    private String maNguoiMuon;
    private String tenNguoiMuon;
    private String gioiTinh;
    private String SDT;
    private String diaChi;
    private String email;

    public Nguoimuon() {

    }

    public Nguoimuon(String maNguoiMuon, String tenNguoiMuon, String gioiTinh, String SDT, String diaChi,
            String email) {
        this.maNguoiMuon = maNguoiMuon;
        this.tenNguoiMuon = tenNguoiMuon;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.email = email;
    }

    public String getMaNguoiMuon() {
        return this.maNguoiMuon;
    }

    public void setMaNguoiMuon(String maNguoiMuon) {
        this.maNguoiMuon = maNguoiMuon;
    }

    public String getTenNguoiMuon() {
        return this.tenNguoiMuon;
    }

    public void setTenNguoiMuon(String tenNguoiMuon) {
        this.tenNguoiMuon = tenNguoiMuon;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String sDT) {
        SDT = sDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
