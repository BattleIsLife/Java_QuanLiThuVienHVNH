package model;

import java.sql.Date;

public class Phieuphat {
    private String maPhieuPhat;
    private float tienPhat;
    private String maNguoiMuon;
    private String maNhanVien;
    private Date thoiGianPhat;
    private String ghiChu;

    public Phieuphat()
    {

    }

    public Phieuphat(String maPhieuPhat, float tienPhat, String maNguoiMuon, String maNhanVien, Date thoiGianPhat, String ghiChu)
    {
        this.maPhieuPhat = maPhieuPhat;
        this.tienPhat = tienPhat;
        this.maNguoiMuon = maNguoiMuon;
        this.maNhanVien = maNhanVien;
        this.thoiGianPhat = thoiGianPhat;
        this.ghiChu = ghiChu;
    }

    public String getMaPhieuPhat() {
        return maPhieuPhat;
    }
    public void setMaPhieuPhat(String maPhieuPhat) {
        this.maPhieuPhat = maPhieuPhat;
    }
    public float getTienPhat() {
        return tienPhat;
    }
    public void setTienPhat(float tienPhat) {
        this.tienPhat = tienPhat;
    }
    public String getMaNguoiMuon() {
        return maNguoiMuon;
    }
    public void setMaNguoiMuon(String maNguoiMuon) {
        this.maNguoiMuon = maNguoiMuon;
    }
    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    public Date getThoiGianPhat() {
        return thoiGianPhat;
    }
    public void setThoiGianPhat(Date thoiGianPhat) {
        this.thoiGianPhat = thoiGianPhat;
    }
    public String getGhiChu() {
        return ghiChu;
    }
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
