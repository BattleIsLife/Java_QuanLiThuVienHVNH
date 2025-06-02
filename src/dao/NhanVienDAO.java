package dao;



import model.Nhanvien;
import model.PermissionLevel;

import java.sql.*;
import java.util.List;

public class NhanVienDAO extends BaseDAO<Nhanvien> {

    public int them(Nhanvien nhanvien) {
        String sql = "INSERT INTO tblNhanVien (Manhanvien, Tennhanvien, Ngaysinh, Gioitinh, Diachi, Email, SDT, Chucvu, Matkhau, Quyenhan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return insert(sql, nhanvien.getMaNhanVien(), nhanvien.getTenNhanVien(), nhanvien.getNgaySinh(), nhanvien.getGioiTinh(),
                nhanvien.getDiaChi(), nhanvien.getEmail(), nhanvien.getSDT(), nhanvien.getChucVu(), nhanvien.getMatKhau(), nhanvien.getQuyenHan().toString());
    }

    public Nhanvien selectById(String maNhanVien) {
        String sql = "SELECT * FROM tblNhanVien WHERE Manhanvien = ?";
        return selectById(sql, maNhanVien);
    }
    public List<Nhanvien> getAll() {
        String sql = "SELECT * FROM tblNhanVien"; 
        return getAll(sql);
    }
    
    public List<Nhanvien> timKiemBangTenOrMa(String text) {
        String sql = "SELECT * FROM tblNhanVien WHERE Manhanvien LIKE CONCAT('%', ?, '%') OR Tennhanvien LIKE CONCAT('%', ?, '%')"; 
        return getAll(sql, text, text);
    }
    
    public Nhanvien findByCredentials(String email,String password) {
    	String sql = "SELECT * FROM tblNhanVien WHERE Manhanvien = ? AND Matkhau = ?";
    	Nhanvien nhanvien =findByCredentials(sql, email, password);
    	return  nhanvien;
    }
    
    public int xoa(String maNhanVien) {
        String sql = "DELETE FROM tblNhanVien WHERE Manhanvien = ?";
        return delete(sql, maNhanVien);
    }
    
    public int sua(Nhanvien nv)
    {
    	String sql = "UPDATE tblNhanVien SET Tennhanvien = ?, Ngaysinh = ?, Gioitinh = ?, Diachi = ?, Email = ?, SDT = ?, Chucvu = ?, Quyenhan = ? WHERE Manhanvien = ?";
    	return update(sql, nv.getTenNhanVien(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getDiaChi(), nv.getEmail(), nv.getSDT(), nv.getChucVu(), nv.getQuyenHan().toString(), nv.getMaNhanVien());
    }

    @Override
    protected Nhanvien mapRow(ResultSet rs) throws SQLException {
        return new Nhanvien(
                rs.getString("Manhanvien"),
                rs.getString("Tennhanvien"),
                rs.getDate("Ngaysinh"),
                rs.getString("Gioitinh"),
                rs.getString("Diachi"),
                rs.getString("Email"),
                rs.getString("SDT"),
                rs.getString("Chucvu"),
                rs.getString("Matkhau"),
                PermissionLevel.valueOf(rs.getString("Quyenhan"))
        );
    }
}
