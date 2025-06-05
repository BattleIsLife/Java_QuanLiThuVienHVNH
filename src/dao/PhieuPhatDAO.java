package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Phieuphat;

public class PhieuPhatDAO extends BaseDAO<Phieuphat>{

	public List<Phieuphat> getAll()
	{
		String sql = "SELECT * FROM tblPhieuPhat";
		return getAll(sql);
	}
	
	public Phieuphat selectById(String id)
	{
		String sql = "SELECT * FROM tblPhieuPhat WHERE Maphieuphat = ?";
		return selectById(sql, id);
	}
	
	public int insert(Phieuphat pp)
	{
		String sql = "INSERT INTO tblPhieuPhat VALUES (?, ?, ?, ?, ?, ?)";
		return insert(sql, pp.getMaPhieuPhat(), pp.getTienPhat(), pp.getMaNguoiMuon(), pp.getMaNhanVien(), pp.getThoiGianPhat(), pp.getGhiChu());
	}
	
	public int update(Phieuphat pp)
	{
		String sql = "UPDATE tblPhieuPhat SET Tienphat = ?, Manguoimuon = ?, Ghichu = ? WHERE Maphieuphat = ?";
		return update(sql, pp.getTienPhat(), pp.getMaNguoiMuon(), pp.getGhiChu(), pp.getMaPhieuPhat());
	}
	
	public int delete(String id)
	{
		String sql = "DELETE FROM tblPhieuPhat WHERE Maphieuphat = ?";
		return update(sql, id);
	}
	
	@Override
	protected Phieuphat mapRow(ResultSet rs) throws SQLException {
		return new Phieuphat(rs.getString("Maphieuphat"),
							 rs.getFloat("Tienphat"),
							 rs.getString("Manguoimuon"),
							 rs.getString("Manhanvien"),
							 rs.getTimestamp("Thoigianphat"),
							 rs.getString("Ghichu"));
	}

}
