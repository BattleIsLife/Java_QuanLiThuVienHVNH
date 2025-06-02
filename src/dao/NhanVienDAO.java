package dao;

import model.Nhanvien;
import model.PermissionLevel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class NhanVienDAO extends BaseDAO<Nhanvien> {

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
                PermissionLevel.valueOf(rs.getString("Quyenhan")));
    }

    public List<Nhanvien> getAll() {
        String sql = "SELECT * FROM tblNhanvien";
        return getAll(sql);
    }

    public Nhanvien selectById(String maNhanvien) {
        String sql = "SELECT * FROM tblNhanvien WHERE MaNhanvien = ?";
        return selectById(sql, maNhanvien);
    }

    public Nhanvien selectByTen(String tenNhanvien) {
        String sql = "SELECT * FROM tblNhanvien WHERE TenNhanvien = ?";
        return selectById(sql, tenNhanvien); // Sử dụng selectById vì logic tương tự
    }

    public Nhanvien findByCredentials(String email, String password) {
        String sql = "SELECT * FROM tblNhanvien WHERE Manhanvien = ? AND Matkhau = ?";
        Nhanvien nhanvien = findByCredentials(sql, email, password);
        return nhanvien;
    }
}