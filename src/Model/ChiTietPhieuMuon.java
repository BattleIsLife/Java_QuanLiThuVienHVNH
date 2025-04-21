package Model;

public class ChiTietPhieuMuon {
    private String maPhieuMuon;
    private String maSach;
    private String soLuong;

    public ChiTietPhieuMuon()
    {

    }

    public ChiTietPhieuMuon(String maPhieuMuon, String maSach, String soLuong)
    {
        this.maPhieuMuon = maPhieuMuon;
        this.maSach = maSach;
        this.soLuong = soLuong;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }
    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }
    public String getMaSach() {
        return maSach;
    }
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    public String getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }
}
