package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import model.Tacgia;

public class TacGiaDAO extends BaseDAO<Tacgia>{

	public int them(Tacgia tg) {
        String sql = "INSERT INTO tblTacGia (Matacgia, Tentacgia, Ngaysinh, Gioitinh, Diachi) VALUES(?, ?, ?, ?, ?)";
        return insert(sql, tg.getMaTacGia(), tg.getTenTacGia(), tg.getNgaySinh(), tg.getGioiTinh(), tg.getDiaChi());
    }
	
	public List<Tacgia> getAll() {
        String sql = "SELECT * FROM tblTacGia"; 
        return getAll(sql);
    }
	
	public Tacgia selectById(String maTacgia) {
        String sql = "SELECT * FROM tblTacGia WHERE Matacgia = ?";
        return selectById(sql, maTacgia);
    }
	
	public Tacgia selectByName(String ten) {
        String sql = "SELECT * FROM tblTacGia WHERE Tentacgia = ?";
        return selectById(sql, ten);
    }
	
	public int sua(Tacgia tg)
	{
		String sql = "UPDATE tblTacGia SET Tentacgia = ?, Ngaysinh = ?, Gioitinh = ?, Diachi = ? WHERE Matacgia = ?";
        return update(sql, tg.getTenTacGia(), tg.getNgaySinh(), tg.getGioiTinh(), tg.getDiaChi(), tg.getMaTacGia());
	}
	
	
	public int xoa(String maTacgia)
	{
		String sql = "DELETE FROM tblTacGia WHERE Matacgia = ?";
		return delete(sql, maTacgia);
	}
	
	@Override
	protected Tacgia mapRow(ResultSet rs) throws SQLException {
		return new Tacgia(
				rs.getString("Matacgia"),
				rs.getString("Tentacgia"),
				rs.getDate("Ngaysinh"),
				rs.getString("Gioitinh"),
				rs.getString("Diachi"));
	}

}
