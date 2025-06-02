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
        String sql = "SELECT * FROM tblnguoimuon";
        return getAll(sql);
    }

    public Nguoimuon selectById(String maNguoimuon) {
        String sql = "SELECT * FROM tblnguoimuon WHERE Manguoimuon = ?";
        return selectById(sql, maNguoimuon);
    }

    public Nguoimuon selectByTen(String tenNguoimuon) {
        String sql = "SELECT * FROM tblnguoimuon WHERE Tennguoimuon = ?";
        return selectById(sql, tenNguoimuon); // Sử dụng selectById vì logic tương tự
    }
}