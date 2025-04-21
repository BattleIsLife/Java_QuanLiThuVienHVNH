package Model;

public class Sach {
    private String maSach;
    private String tenSach;
    private String maTacGia;
    private String maNXB;
    private float giaSach;
    private int soLuong;
    private String anh;
    private String ghiChu;

    public Sach()
    {

    }

    public Sach(String maSach, String tenSach, String maTacGia, String maNXB, float giaSach, int soLuong, String anh, String ghiChu)
    {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maTacGia = maTacGia;
        this.maNXB = maNXB;
        this.giaSach = giaSach;
        this.soLuong = soLuong;
        this.anh = anh;
        this.ghiChu = ghiChu;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public float getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(float giaSach) {
        this.giaSach = giaSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getGhiChu() {
        return ghiChu;
    }
    
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
