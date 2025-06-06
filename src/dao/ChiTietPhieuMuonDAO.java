package dao;

import model.ChiTietPhieuMuonModel;
import model.ChiTietPhieuMuonDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChiTietPhieuMuonDAO extends BaseDAO<ChiTietPhieuMuonModel> {

    public void them(ChiTietPhieuMuonModel ctm) {
        String sql = "INSERT INTO tblChiTietPhieuMuon (Maphieumuon, Masach, Soluongmuon) VALUES (?, ?, ?)";
        insert(sql, ctm.getMaphieumuon(), ctm.getMasach(), ctm.getSoluongmuon());
    }

    public void xoa(String maphieumuon, String masach) {
        String sql = "DELETE FROM tblChiTietPhieuMuon WHERE Maphieumuon = ? and Masach = ?";
        delete(sql, maphieumuon, masach);
    }

    public void sua(ChiTietPhieuMuonModel ctm) {
        String sql = "UPDATE tblChiTietPhieuMuon SET  Soluongmuon = ? WHERE Maphieumuon = ? AND Masach = ?";
        update(sql, ctm.getSoluongmuon(), ctm.getMaphieumuon(), ctm.getMasach());
    }

    public List<ChiTietPhieuMuonDTO> getAll() {
        List<ChiTietPhieuMuonDTO> list = new ArrayList<>();
        String sql = "SELECT c.Maphieumuon, c.Masach, s.Tensach, c.Soluongmuon " +
                "FROM tblChiTietPhieuMuon c JOIN tblSach s ON c.Masach = s.Masach";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietPhieuMuonDTO ctm = new ChiTietPhieuMuonDTO();
                ctm.setMaphieumuon(rs.getString("Maphieumuon"));
                ctm.setMasach(rs.getString("Masach"));
                ctm.setTensach(rs.getString("Tensach"));
                ctm.setSoluongmuon(rs.getInt("Soluongmuon"));
                list.add(ctm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void xoaChiTietPhieuMuon(String maphieumuon) {
        String sql = "DELETE FROM tblChiTietPhieuMuon WHERE Maphieumuon = ?";
        delete(sql, maphieumuon);
    }

    public ChiTietPhieuMuonModel findbyId(String maphieumuon, String masach) {
        String sql = "SELECT * FROM tblChiTietPhieuMuon WHERE Maphieumuon = ? AND Masach = ?";
        return selectById(sql, maphieumuon, masach);
    }

    public boolean checkBookAvailability(String masach, int soluongmuon) {
        String sql = "SELECT Soluong FROM tblSach WHERE Masach = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, masach);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int available = rs.getInt("Soluong");
                System.err.println("Available quantity for book " + masach + ": " + available);
                return soluongmuon <= available;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateBookQuantity(String masach, int soluongmuon, boolean isAdding) {
        String sql = "UPDATE tblSach SET Soluong = Soluong " + (isAdding ? "-" : "+") + " ? WHERE Masach = ?";
        update(sql, soluongmuon, masach);
    }

    @Override
    protected ChiTietPhieuMuonModel mapRow(ResultSet rs) throws SQLException {
        ChiTietPhieuMuonModel ctm = new ChiTietPhieuMuonModel();
        ctm.setMaphieumuon(rs.getString("Maphieumuon"));
        ctm.setMasach(rs.getString("Masach"));
        ctm.setSoluongmuon(rs.getInt("Soluongmuon"));
        return ctm;
    }
}