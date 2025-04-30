package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Nhaxuatban;

public class NhaXuatBanDAO extends BaseDAO<Nhaxuatban>{

	public int them(Nhaxuatban nxb) {
        String sql = "INSERT INTO tblNXB (MaNXB, TenNXB, Diachi, SDT, Email) VALUES(?, ?, ?, ?, ?)";
        return insert(sql, nxb.getMaNXB(), nxb.getTenNXB(), nxb.getDiaChi(), nxb.getSDT(), nxb.getEmail());
    }
	
	public List<Nhaxuatban> getAll() {
        String sql = "SELECT * FROM tblNXB"; 
        return getAll(sql);
    }
	
	public Nhaxuatban selectById(String maNXB) {
        String sql = "SELECT * FROM tblNXB WHERE MaNXB = ?";
        return selectById(sql, maNXB);
    }
	
	public Nhaxuatban selectByName(String ten) {
        String sql = "SELECT * FROM tblNXB WHERE TenNXB = ?";
        return selectById(sql, ten);
    }
	
	public int sua(Nhaxuatban nxb)
	{
		String sql = "UPDATE tblNXB SET TenNXB = ?, Diachi = ?, SDT = ?, Email = ? WHERE MaNXB = ?";
        return update(sql, nxb.getTenNXB(), nxb.getDiaChi(), nxb.getSDT(), nxb.getEmail(), nxb.getMaNXB());
	}
	
	public int xoa(String maNXB)
	{
		String sql = "DELETE FROM tblNXB WHERE MaNXB = ?";
		return delete(sql, maNXB);
	}
	
	@Override
	protected Nhaxuatban mapRow(ResultSet rs) throws SQLException {
		return new Nhaxuatban(
				rs.getString("MaNXB"),
				rs.getString("TenNXB"),
				rs.getString("Diachi"),
				rs.getString("SDT"),
				rs.getString("Email"));				
	}

}
