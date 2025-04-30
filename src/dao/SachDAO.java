package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Sach;

public class SachDAO extends BaseDAO<Sach>{

	public int them(Sach s) {
        String sql = "INSERT INTO tblSach (Masach, Tensach, Matheloai, Matacgia, MaNXB, Giasach, Soluong, Anh, Ghichu) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return insert(sql, s.getMaSach(), s.getTenSach(), s.getMaTheLoai(), s.getMaTacGia(), s.getMaNXB(), s.getGiaSach(), s.getSoLuong(), s.getAnh(), s.getGhiChu());
    }
	
	public List<Sach> getAll() {
        String sql = "SELECT * FROM tblSach"; 
        return getAll(sql);
    }
	
	public Sach selectById(String maSach) {
        String sql = "SELECT * FROM tblSach WHERE Masach = ?";
        return selectById(sql, maSach);
    }
	
	public int sua(Sach s)
	{
		String sql = "UPDATE tblSach SET Tensach = ?, Matheloai = ?, Matacgia = ?, MaNXB = ?, Giasach = ?, Soluong = ?, Anh = ?, Ghichu = ? WHERE Masach = ?";
        return update(sql, s.getTenSach(), s.getMaTheLoai(), s.getMaTacGia(), s.getMaNXB(), s.getGiaSach(), s.getSoLuong(), s.getAnh(), s.getGhiChu(), s.getMaSach());
	}
	
	
	public int xoa(String maSach)
	{
		String sql = "DELETE FROM tblSach WHERE MaSach = ?";
		return delete(sql, maSach);
	}
	
	@Override
	protected Sach mapRow(ResultSet rs) throws SQLException {
		return new Sach(
				rs.getString("Masach"),
				rs.getString("Tensach"),
				rs.getString("Matheloai"),
				rs.getString("Matacgia"),
				rs.getString("MaNXB"),
				rs.getFloat("Giasach"),
				rs.getInt("Soluong"),
				rs.getString("Anh"),
				rs.getString("Ghichu"));
	}

}
