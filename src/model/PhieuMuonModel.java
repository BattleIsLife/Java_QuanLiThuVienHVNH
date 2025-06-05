package model;

import java.util.Date;

public class PhieuMuonModel {
    private String maphieumuon;
    private Date ngaymuon;
    private Date hantrasach;
    private String manguoimuon;
    private String manhanvien;

    public PhieuMuonModel() {
    }

    public PhieuMuonModel(String maNguoiMuon, Date ngayMuon, Date hanTraSach, String maPhieuMuon, String maNhanVien) {
        this.manguoimuon = maNguoiMuon;
        this.ngaymuon = ngayMuon;
        this.hantrasach = hanTraSach;
        this.manguoimuon = maPhieuMuon;
        this.manhanvien = maNhanVien;
    }

    public String getMaphieumuon() {
        return maphieumuon;
    }

    public void setMaphieumuon(String maphieumuon) {
        this.maphieumuon = maphieumuon;
    }

    public Date getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(Date ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public Date getHantrasach() {
        return hantrasach;
    }

    public void setHantrasach(Date hantrasach) {
        this.hantrasach = hantrasach;
    }

    public String getManguoimuon() {
        return manguoimuon;
    }

    public void setManguoimuon(String manguoimuon) {
        this.manguoimuon = manguoimuon;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public void setManhanvien(String manhanvien) {
        this.manhanvien = manhanvien;
    }
}