package dao;

import model.Nguoimuon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class NguoiMuonDAO extends BaseDAO<Nguoimuon> {

    @Override
    protected Nguoimuon mapRow(ResultSet rs) throws SQLException {
        Nguoimuon nm = new Nguoimuon();
        nm.setMaNguoiMuon(rs.getString("Manguoimuon"));
        nm.setTenNguoiMuon(rs.getString("Tennguoimuon"));
        nm.setGioiTinh(rs.getString("Gioitinh"));
        nm.setSDT(rs.getString("SDT"));
        nm.setDiaChi(rs.getString("Diachi"));
        nm.setEmail(rs.getString("Email"));
        return nm;
    }

    public List<Nguoimuon> getAll() {
        String sql = "SELECT * FROM tblNguoiMuon";
        return getAll(sql);
    }

    public Nguoimuon selectById(String maNguoimuon) {
        String sql = "SELECT * FROM tblNguoiMuon WHERE Manguoimuon = ?";
        return selectById(sql, maNguoimuon);
    }

    public Nguoimuon selectByTen(String tenNguoimuon) {
        String sql = "SELECT * FROM tblNguoiMuon WHERE Tennguoimuon = ?";
        return selectById(sql, tenNguoimuon); // Sử dụng selectById vì logic tương tự
    }

    public List<Nguoimuon> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM tblNguoiMuon WHERE Mannguoimuon LIKE CONCAT('%', ?, '%') Tennguoimuon = LIKE CONCAT('%', ?, '%')";
        return getAll(sql, keyword); // Sử dụng selectByKeyword vì logic tương tự
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
}