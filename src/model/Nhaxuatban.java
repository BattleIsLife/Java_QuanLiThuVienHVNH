package model;



public class Nhaxuatban {
    private String maNXB;
    private String tenNXB;
    private String diaChi;
    private String SDT;
    private String email;

    public Nhaxuatban()
    {

    }

    public Nhaxuatban(String maNXB, String tenNXB, String diaChi, String SDT, String email)
    {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.email = email;
    }

    public String getMaNXB() {
        return maNXB;
    }
    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }
    public String getTenNXB() {
        return tenNXB;
    }
    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getSDT() {
        return SDT;
    }
    public void setSDT(String sDT) {
        SDT = sDT;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}
