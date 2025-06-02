package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Nguoimuon;

public class NguoiMuonDAO extends BaseDAO<Nguoimuon>{
    private Connection conn;
    
    // Lấy tất cả người mượn
    public List<Nguoimuon> getAll() {
        List<Nguoimuon> list = new ArrayList<>();
        String sql = "SELECT * FROM tblNguoiMuon";
        return getAll(sql);
    }

    // Tìm người mượn theo mã
    public Nguoimuon findByMa(String ma) {
        String sql = "SELECT * FROM tblNguoiMuon WHERE Manguoimuon = ?";
        return selectById(sql, ma);
    }

    // Thêm mới người mượn
    public int insert(Nguoimuon nm) {
        String sql = "INSERT INTO tblNguoiMuon VALUES (?, ?, ?, ?, ?, ?)";
        return insert(sql, nm.getMaNguoiMuon(), nm.getTenNguoiMuon(), nm.getGioiTinh(), nm.getSDT(), nm.getDiaChi(), nm.getEmail());
    }

    // Cập nhật thông tin người mượn
    public int update(Nguoimuon nm) {
        String sql = "UPDATE tblNguoiMuon SET Tennguoimuon = ?, Gioitinh = ?, SDT = ?, Diachi = ?, Email = ? WHERE Manguoimuon = ?";
        return insert(sql, nm.getTenNguoiMuon(), nm.getGioiTinh(), nm.getSDT(), nm.getDiaChi(), nm.getEmail(), nm.getMaNguoiMuon());
    }

    // Xóa người mượn theo mã
    public int delete(String ma) {
        String sql = "DELETE FROM tblNguoiMuon WHERE Manguoimuon = ?";
        return delete(sql, ma);
    }

    // Tìm kiếm người mượn theo mã hoặc tên (keyword)
    public List<Nguoimuon> findByKeyword(String keyword) {
        String sql = "SELECT * FROM tblNguoiMuon WHERE Manguoimuon LIKE CONCAT('%', ?, '%') OR Tennguoimuon LIKE CONCAT('%', ?, '%')";
        return getAll(sql, keyword, keyword);
    }

	@Override
	protected Nguoimuon mapRow(ResultSet rs) throws SQLException {
		return new Nguoimuon(
				rs.getString("Manguoimuon"),
				rs.getString("Tennguoimuon"),
				rs.getString("Gioitinh"),
				rs.getString("SDT"),
				rs.getString("Diachi"),
				rs.getString("Email"));
	}
}
