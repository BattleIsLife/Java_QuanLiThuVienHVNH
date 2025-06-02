package dao;

import model.PhieuMuonModel;
import model.PhieuMuonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.sql.Date;

public class PhieuMuonDAO extends BaseDAO<PhieuMuonModel> {

    @Override
    protected PhieuMuonModel mapRow(ResultSet rs) throws SQLException {
        PhieuMuonModel pm = new PhieuMuonModel();
        pm.setMaphieumuon(rs.getString("Maphieumuon"));
        pm.setNgaymuon(rs.getTimestamp("Ngaymuon"));
        pm.setHantrasach(rs.getDate("Hantrasach"));
        pm.setManguoimuon(rs.getString("Manguoimuon"));
        pm.setManhanvien(rs.getString("Manhanvien"));
        return pm;
    }

    public List<PhieuMuonDTO> getAll() {
        List<PhieuMuonDTO> list = new ArrayList<>();
        String sql = "SELECT pm.Maphieumuon, pm.Ngaymuon, pm.Hantrasach, " +
                "nm.Tennguoimuon AS TenNguoiMuon, nv.Tennhanvien AS TenNhanVien " +
                "FROM tblphieumuon pm " +
                "JOIN tblnguoimuon nm ON pm.Manguoimuon = nm.Manguoimuon " +
                "JOIN tblnhanvien nv ON pm.Manhanvien = nv.Manhanvien";

        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                PhieuMuonDTO dto = new PhieuMuonDTO(
                        rs.getString("Maphieumuon"),
                        rs.getTimestamp("Ngaymuon"),
                        rs.getDate("Hantrasach"),
                        rs.getString("TenNguoiMuon"),
                        rs.getString("TenNhanVien"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving PhieuMuonDTO list: " + e.getMessage());
        }
        return list;
    }

    public PhieuMuonModel selectById(String maphieumuon) {
        String sql = "SELECT * FROM tblPhieuMuon WHERE Maphieumuon = ?";
        return selectById(sql, maphieumuon);
    }

    public void them(PhieuMuonModel pm) {
        String sql = "INSERT INTO tblPhieuMuon (Maphieumuon, Ngaymuon, Hantrasach, Manguoimuon, Manhanvien) VALUES (?, ?, ?, ?, ?)";
        insert(sql, pm.getMaphieumuon(), new Timestamp(pm.getNgaymuon().getTime()),
                new Date(pm.getHantrasach().getTime()), pm.getManguoimuon(), pm.getManhanvien());
    }

    public void sua(PhieuMuonModel pm) {
        String sql = "UPDATE tblPhieuMuon SET Ngaymuon = ?, Hantrasach = ?, Manguoimuon = ?, Manhanvien = ? WHERE Maphieumuon = ?";
        update(sql, new Timestamp(pm.getNgaymuon().getTime()), new Date(pm.getHantrasach().getTime()),
                pm.getManguoimuon(), pm.getManhanvien(), pm.getMaphieumuon());
    }

    public void xoa(String maphieumuon) {
        String sql = "DELETE FROM tblPhieuMuon WHERE Maphieumuon = ?";
        delete(sql, maphieumuon);
    }
}