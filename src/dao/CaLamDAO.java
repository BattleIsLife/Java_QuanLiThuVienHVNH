package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Calam;

public class CaLamDAO extends BaseDAO<Calam>{

    public List<Calam> getAll()
    {
        String sql = "SELECT * FROM tblCaLam";
        return getAll(sql);
    }

    public Calam selectById(String id)
    {
        String sql = "SELECT * FROM tblCaLam WHERE Macalam = ?";
        return selectById(sql, id);
    }

    public Calam selectByNV(String id)
    {
        String sql = "SELECT * FROM tblCaLam WHERE Manhanvien = ?";
        return selectById(sql, id);
    }

    public int insert(Calam cl)
    {
        String sql = "INSERT INTO tblCaLam VALUES(?, ?, ?)";
        return insert(sql, cl.getMaCaLam(), cl.getMaNhanVien(), cl.getThoiGian());
    }

    public int update(Calam cl)
    {
        String sql = "UPDATE tblCaLam SET Manhanvien = ?, Thoigian = ? WHERE Macalam = ?";
        return update(sql, cl.getMaNhanVien(), cl.getThoiGian(), cl.getMaCaLam());
    }

    public int delete(String id)
    {
        String sql = "DELETE FROM tblCaLam WHERE Macalam = ?";
        return update(sql, id);
    }

    @Override
    protected Calam mapRow(ResultSet rs) throws SQLException {
        return new Calam(rs.getString("Macalam"),
                    rs.getString("Manhanvien"),
                    rs.getDate("Thoigian"));
    }
    
}
