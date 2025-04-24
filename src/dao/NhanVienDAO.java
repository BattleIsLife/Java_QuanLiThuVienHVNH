package dao;



import model.Nhanvien;
import model.PermissionLevel;

import java.sql.*;
import java.util.List;

public class NhanVienDAO extends BaseDAO<Nhanvien> {

    public int them(Nhanvien nhanvien) {
        String sql = "INSERT INTO tblNhanVien (Manhanvien, Tennhanvien, Ngaysinh, Gioitinh, Diachi, Email, SDT, Chucvu, Matkhau, Quyenhan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return insert(sql, nhanvien.getMaNhanVien(), nhanvien.getTenNhanVien(), nhanvien.getNgaySinh(), nhanvien.getGioiTinh(),
                nhanvien.getDiaChi(), nhanvien.getEmail(), nhanvien.getSDT(), nhanvien.getChucVu(), nhanvien.getMatKhau(), nhanvien.getQuyenHan().name());
    }

    public Nhanvien selectById(String maNhanVien) {
        String sql = "SELECT * FROM tblNhanVien WHERE Manhanvien = ?";
        return selectById(sql, maNhanVien);
    }
    public List<Nhanvien> getAll() {
        String sql = "SELECT * FROM tblnhanvien"; 
        return getAll(sql);
    }
    public Nhanvien findByCredentials(String email,String password) {
    	String sql = "SELECT * FROM tblNhanvien WHERE Manhanvien = ? AND Matkhau = ?";
    	Nhanvien nhanvien =findByCredentials(sql, email, password);
    	return  nhanvien;
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
