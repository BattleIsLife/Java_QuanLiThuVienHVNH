package model;


import java.sql.Date;

public class Phieumuon {
    private String maPhieuMuon;
    private Date ngayMuon;
    private Date hanTraSach;
    private String maNguoiMuon;
    private String maNhanVien;

    public Phieumuon()
    {

    }

    public Phieumuon(String maPhieuMuon, Date ngayMuon, Date hanTraSach, String maNguoiMuon, String maNhanVien)
    {
        this.maPhieuMuon = maPhieuMuon;
        this.ngayMuon = ngayMuon;
        this.hanTraSach = hanTraSach;
        this.maNguoiMuon = maNguoiMuon;
        this.maNhanVien = maNhanVien;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }
    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }
    public Date getNgayMuon() {
        return ngayMuon;
    }
    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }
    public Date getHanTraSach() {
        return hanTraSach;
    }
    public void setHanTraSach(Date hanTraSach) {
        this.hanTraSach = hanTraSach;
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
}
