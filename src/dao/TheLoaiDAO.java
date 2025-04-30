package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Theloai;

public class TheLoaiDAO extends BaseDAO<Theloai>{

	public int them(Theloai theloai) {
        String sql = "INSERT INTO tblTheLoai (Matheloai, Tentheloai) VALUES(?, ?)";
        return insert(sql, theloai.getMaTheLoai(), theloai.getTenTheLoai());
    }
	
	public List<Theloai> getAll() {
        String sql = "SELECT * FROM tblTheLoai"; 
        return getAll(sql);
    }
	
	public Theloai selectById(String maTheloai) {
        String sql = "SELECT * FROM tblTheLoai WHERE Matheloai = ?";
        return selectById(sql, maTheloai);
    }
	
	public Theloai selectByName(String ten) {
        String sql = "SELECT * FROM tblTheLoai WHERE Tentheloai = ?";
        return selectById(sql, ten);
    }
	
	public int sua(Theloai theloai)
	{
		String sql = "UPDATE tblTheLoai SET Tentheloai = ? WHERE Matheloai = ?";
        return update(sql, theloai.getTenTheLoai(), theloai.getMaTheLoai());
	}
	
	public int xoa(String maTheloai)
	{
		String sql = "DELETE FROM tblTheLoai WHERE Matheloai = ?";
		return delete(sql, maTheloai);
	}
	
	public List<Theloai> findByCredential(String Matheloai, String Tentheloai)
	{
		String sql = "SELECT * FROM tblTheLoai WHERE Matheloai LIKE '%?%', Tentheloai LIKE '%?%'";
		return getAll(sql, Matheloai, Tentheloai);
	}
	
	@Override
	protected Theloai mapRow(ResultSet rs) throws SQLException {
		return new Theloai(
				rs.getString("Matheloai"),
				rs.getString("Tentheloai"));				
	}

}
