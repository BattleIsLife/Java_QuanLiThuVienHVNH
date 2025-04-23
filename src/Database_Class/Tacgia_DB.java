package Database_Class;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import JDBC_Class.JDBC_Util;
import Model.Tacgia;

public class Tacgia_DB implements GenericDB<Tacgia>{

    public static Tacgia_DB getInstance()
    {
        return new Tacgia_DB();
    }

    @Override
    public int Them(Tacgia t) {
        int ketQua = 0;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String maTacGia = t.getMaTacGia();
            String tenTacGia = t.getTenTacGia();
            Date ngaySinh = t.getNgaySinh();
            String gioiTinh = t.getGioiTinh();
            String diaChi = t.getDiaChi();

            String sql = "INSERT INTO tblTacGia(Matacgia, Tentacgia, Ngaysinh, Gioitinh, Diachi) VALUES " +
                         "('" + maTacGia + "', N'" + tenTacGia + "', '" + ngaySinh + "', N'" + gioiTinh + "', N'" + diaChi + "')";

            ketQua = statement.executeUpdate(sql);

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int Sua(Tacgia t) {
        int ketQua = 0;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String maTacGia = t.getMaTacGia();
            String tenTacGia = t.getTenTacGia();
            Date ngaySinh = t.getNgaySinh();
            String gioiTinh = t.getGioiTinh();
            String diaChi = t.getDiaChi();

            String sql = "UPDATE tblTacGia SET" +
                        " Tentacgia = N'" + tenTacGia + "'" +
                        ", Ngaysinh = '" + ngaySinh + "'" +
                        ", Gioitinh = N'" + gioiTinh + "'" +
                        ", Diachi = N'" + diaChi + "'" +
                        " WHERE Matacgia = '" + maTacGia + "'";

            ketQua = statement.executeUpdate(sql);

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int Xoa(Tacgia t) {
        int ketQua = 0;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String maTacGia = t.getMaTacGia();

            String sql = "DELETE FROM tblTacGia WHERE Matacgia = '" + maTacGia + "'";

            ketQua = statement.executeUpdate(sql);

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Dữ liệu đang được sử dụng bởi 1 bảng khác, không thể xóa", "Lỗi", JOptionPane.WARNING_MESSAGE); 
        }
        return ketQua;
    }

    @Override
    public ArrayList<Tacgia> selectAll() {
        ArrayList<Tacgia> list = new ArrayList<Tacgia>();
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String sql = "SELECT * FROM tblTacGia";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next())
            {
                String maTacGia = rs.getString("Matacgia");
                String tenTacGia = rs.getString("Tentacgia");
                Date ngaySinh = rs.getDate("Ngaysinh");
                String gioiTinh = rs.getString("Gioitinh");
                String diaChi = rs.getString("Diachi");

                Tacgia tacgia = new Tacgia(maTacGia, tenTacGia, ngaySinh, gioiTinh, diaChi);
                list.add(tacgia);
            }

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Tacgia selectById(String Id) {
        Tacgia tacgia = null;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String sql = "SELECT * FROM tblTacGia WHERE Matacgia = '" + Id + "'";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next())
            {
                String maTacGia = rs.getString("Matacgia");
                String tenTacGia = rs.getString("Tentacgia");
                Date ngaySinh = rs.getDate("Ngaysinh");
                String gioiTinh = rs.getString("Gioitinh");
                String diaChi = rs.getString("Diachi");

                tacgia = new Tacgia(maTacGia, tenTacGia, ngaySinh, gioiTinh, diaChi);
            }

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tacgia;
    }

    @Override
    public ArrayList<Tacgia> selectByCondition(String condition) {
        ArrayList<Tacgia> list = new ArrayList<Tacgia>();
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String sql = "SELECT * FROM tblTacGia WHERE " + condition;
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next())
            {
                String maTacGia = rs.getString("Matacgia");
                String tenTacGia = rs.getString("Tentacgia");
                Date ngaySinh = rs.getDate("Ngaysinh");
                String gioiTinh = rs.getString("Gioitinh");
                String diaChi = rs.getString("Diachi");

                Tacgia tacgia = new Tacgia(maTacGia, tenTacGia, ngaySinh, gioiTinh, diaChi);
                list.add(tacgia);
            }

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
