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
                "FROM tblPhieuMuon pm " +
                "JOIN tblNguoiMuon nm ON pm.Manguoimuon = nm.Manguoimuon " +
                "JOIN tblNhanVien nv ON pm.Manhanvien = nv.Manhanvien";

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

    private boolean isValidNguoiMuon(String manguoimuon) {
        String sql = "SELECT COUNT(*) FROM tblNguoiMuon WHERE Manguoimuon = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, manguoimuon);
            ResultSet rs = ps.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error validating Manguoimuon: " + e.getMessage());
        }
    }

    private boolean isValidNhanVien(String manhanvien) {
        String sql = "SELECT COUNT(*) FROM tblNhanVien WHERE Manhanvien = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, manhanvien);
            ResultSet rs = ps.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error validating Manhanvien: " + e.getMessage());
        }
    }

    public void sua(PhieuMuonModel pm) {
        if (pm.getMaphieumuon() == null || pm.getNgaymuon() == null || pm.getHantrasach() == null ||
                pm.getManguoimuon() == null || pm.getManhanvien() == null) {
            throw new IllegalArgumentException("All fields must be non-null");
        }
        if (!isValidNguoiMuon(pm.getManguoimuon())) {
            throw new IllegalArgumentException("Invalid Manguoimuon: " + pm.getManguoimuon());
        }
        if (!isValidNhanVien(pm.getManhanvien())) {
            throw new IllegalArgumentException("Invalid Manhanvien: " + pm.getManhanvien());
        }
        PhieuMuonModel existing = selectById(pm.getMaphieumuon());
        if (existing == null) {
            throw new IllegalArgumentException("No PhieuMuon found with Maphieumuon: " + pm.getMaphieumuon());
        }
        System.out.println("Updating PhieuMuon: Maphieumuon=" + pm.getMaphieumuon() + ", Ngaymuon=" + pm.getNgaymuon() +
                ", Hantrasach=" + pm.getHantrasach() + ", Manguoimuon=" + pm.getManguoimuon() +
                ", Manhanvien=" + pm.getManhanvien());
        String sql = "UPDATE tblPhieuMuon SET Ngaymuon = ?, Hantrasach = ?, Manguoimuon = ?, Manhanvien = ? WHERE Maphieumuon = ?";
        int rowsAffected = update(sql, new Timestamp(pm.getNgaymuon().getTime()),
                new Date(pm.getHantrasach().getTime()),
                pm.getManguoimuon(), pm.getManhanvien(), pm.getMaphieumuon());
        System.out.println("Rows affected: " + rowsAffected);
        if (rowsAffected == 0) {
            throw new RuntimeException("No rows updated for Maphieumuon: " + pm.getMaphieumuon());
        }
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

    public void xoa(String maphieumuon) {

        String sql = "DELETE FROM tblPhieuMuon WHERE Maphieumuon = ?";
        delete(sql, maphieumuon);
    }
}