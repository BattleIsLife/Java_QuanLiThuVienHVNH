package model;

import java.util.Date;

public class PhieuMuonDTO {
    private String maphieumuon;
    private Date ngaymuon;
    private Date hantrasach;
    private String tennguoimuon;
    private String tennhanvien;

    public PhieuMuonDTO(String maphieumuon, Date ngaymuon, Date hantrasach,
            String tennguoimuon, String tennhanvien) {
        this.maphieumuon = maphieumuon;
        this.ngaymuon = ngaymuon;
        this.hantrasach = hantrasach;
        this.tennguoimuon = tennguoimuon;
        this.tennhanvien = tennhanvien;
    }

    public PhieuMuonDTO() {
    }

    public String getMaphieumuon() {
        return maphieumuon;
    }

    public Date getNgaymuon() {
        return ngaymuon;
    }

    public Date getHantrasach() {
        return hantrasach;
    }

    public String getTennguoimuon() {
        return tennguoimuon;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setMaphieumuon(String maphieumuon) {
        this.maphieumuon = maphieumuon;
    }

    public void setNgaymuon(Date ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public void setHantrasach(Date hantrasach) {
        this.hantrasach = hantrasach;
    }

    public void setTennguoimuon(String tennguoimuon) {
        this.tennguoimuon = tennguoimuon;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }
}