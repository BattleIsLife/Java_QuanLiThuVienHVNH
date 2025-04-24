package model;

import java.sql.Date;

public class Calam {
    private String maCaLam;
    private String maNhanVien;
    private Date thoiGian;

    public Calam()
    {
        
    }

    public Calam(String maCaLam, String maNhanVien, Date thoiGian)
    {
        this.maCaLam = maCaLam;
        this.maNhanVien = maNhanVien;
        this.thoiGian = thoiGian;
    }

    public String getMaCaLam() {
        return maCaLam;
    }
    public void setMaCaLam(String maCaLam) {
        this.maCaLam = maCaLam;
    }
    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    public Date getThoiGian() {
        return thoiGian;
    }
    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }
}
