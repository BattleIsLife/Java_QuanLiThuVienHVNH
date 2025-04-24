package model;


import java.sql.Date;

public class Nhanvien {
    private String maNhanVien;
    private String tenNhanVien;
    private Date ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String email;
    private String SDT;
    private String chucVu;
    private String matKhau;
    private PermissionLevel quyenHan;


    //NONE: Không được xem bất kì cái gì, chỉ được xem, sửa thông tin của bản thân
    //NHANVIEN: Bao gồm quyền hạn mức NONE, được xem thông tin sách, tác giả, thể loại, NXB, 
    //          được thêm phiều mượn và phiếu phạt, không được xem danh sách các nhân viên khác
    //ADMIN: Toàn quyền thêm, sửa, xóa

    public Nhanvien()
    {

    }

    public Nhanvien(String maNhanVien, String tenNhanVien, Date ngaySinh, String gioiTinh, String diaChi, String email, String SDT, String chucVu, String matKhau, PermissionLevel quyenHan)
    {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.email = email;
        this.SDT = SDT;
        this.chucVu = chucVu;
        this.matKhau = matKhau;
        this.quyenHan = quyenHan;
    }


    public String getMaNhanVien() {
        return maNhanVien;
    }
    
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSDT() {
        return SDT;
    }
    
    public void setSDT(String sDT) {
        SDT = sDT;
    }
    
    public String getChucVu() {
        return chucVu;
    }
    
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    } 

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public PermissionLevel getQuyenHan() {
        return quyenHan;
    }

    public void setQuyenHan(PermissionLevel quyenHan) {
        this.quyenHan = quyenHan;
    }
    
}