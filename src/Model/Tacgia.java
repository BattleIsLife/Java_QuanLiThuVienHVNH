package Model;

import java.sql.Date;

public class Tacgia {
    private String maTacGia;
    private String tenTacGia;
    private Date ngaySinh;
    private String gioiTinh;
    private String diaChi;

    public Tacgia()
    {

    }

    public Tacgia(String maTacGia, String tenTacGia, Date ngaySinh, String gioiTinh, String diaChi)
    {
        this.maTacGia = maTacGia;
        this.tenTacGia = tenTacGia;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public String getMaTacGia() {
        return maTacGia;
    }
    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }
    public String getTenTacGia() {
        return tenTacGia;
    }
    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }
    public Date getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
