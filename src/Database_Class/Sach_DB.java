package Database_Class;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import JDBC_Class.JDBC_Util;
import Model.Sach;

public class Sach_DB implements GenericDB<Sach>{
    public static Sach_DB getInstance()
    {
        return new Sach_DB();
    }

    @Override
    public int Them(Sach t) {
        int ketQua = 0;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String maSach = t.getMaSach();
            String tenSach = t.getTenSach();
            String maTheLoai = t.getMaTheLoai();
            String maTacGia = t.getMaTacGia();
            String maNXB = t.getMaNXB();
            float giaSach = t.getGiaSach();
            int soLuong = t.getSoLuong();
            String anh = t.getAnh();
            String ghiChu = t.getGhiChu();

            String sql = "INSERT INTO tblSach(Masach, Tensach, Matheloai, Matacgia, MaNXB, Giasach, Soluong, Anh, Ghichu) VALUES " +
                         "('" + maSach + "', N'" + tenSach + "', '" + maTheLoai + "', '" + maTacGia + "', '" + maNXB + "', " + giaSach + ", " + soLuong + ", '" + anh + "', N'" + ghiChu + "')";

            ketQua = statement.executeUpdate(sql);

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int Sua(Sach t) {
        int ketQua = 0;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String maSach = t.getMaSach();
            String tenSach = t.getTenSach();
            String maTheLoai = t.getMaTheLoai();
            String maTacGia = t.getMaTacGia();
            String maNXB = t.getMaNXB();
            float giaSach = t.getGiaSach();
            int soLuong = t.getSoLuong();
            String anh = t.getAnh();
            String ghiChu = t.getGhiChu();

            String sql = "UPDATE tblSach SET" + 
                        " Tensach = N'" + tenSach + "'" +
                        ", Matheloai = '" + maTheLoai + "'" +
                        ", Matacgia = '" + maTacGia + "'" +
                        ", MaNXB = '" + maNXB + "'" +
                        ", Giasach = " + giaSach +
                        ", Soluong = " + soLuong +
                        ", Anh = '" + anh + "'" +
                        ", Ghichu = N'" + ghiChu + "'" +
                        " WHERE Masach = '" + maSach + "'";

            ketQua = statement.executeUpdate(sql);

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int Xoa(Sach t) {
        int ketQua = 0;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String maSach = t.getMaSach();

            String sql = "DELETE FROM tblSach WHERE Masach = '" + maSach + "'";

            ketQua = statement.executeUpdate(sql);

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> list = new ArrayList<Sach>();
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String sql = "SELECT * FROM tblSach";

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maSach = rs.getString("Masach");
                String tenSach = rs.getString("Tensach");
                String maTheLoai = rs.getString("Matheloai");
                String maTacGia = rs.getString("Matacgia");
                String maNXB = rs.getString("MaNXB");
                float giaSach = rs.getFloat("Giasach");
                int soLuong = rs.getInt("Soluong");
                String anh = rs.getString("Anh");
                String ghiChu = rs.getString("Ghichu");

                Sach sach = new Sach(maSach, tenSach, maTheLoai, maTacGia, maNXB, giaSach, soLuong, anh, ghiChu);
                list.add(sach);
            }

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Dữ liệu đang được sử dụng bởi 1 bảng khác, không thể xóa", "Lỗi", JOptionPane.WARNING_MESSAGE);
        }
        return list;
    }

    @Override
    public Sach selectById(String Id) {
        Sach sach = null;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String sql = "SELECT * FROM tblSach WHERE Masach = '" + Id + "'";

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maSach = rs.getString("Masach");
                String tenSach = rs.getString("Tensach");
                String maTheLoai = rs.getString("Matheloai");
                String maTacGia = rs.getString("Matacgia");
                String maNXB = rs.getString("MaNXB");
                float giaSach = rs.getFloat("Giasach");
                int soLuong = rs.getInt("Soluong");
                String anh = rs.getString("Anh");
                String ghiChu = rs.getString("Ghichu");

                sach = new Sach(maSach, tenSach, maTheLoai, maTacGia, maNXB, giaSach, soLuong, anh, ghiChu);
            }

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sach;
    }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
        ArrayList<Sach> list = new ArrayList<Sach>();
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String sql = "SELECT * FROM tblSach WHERE " + condition;

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maSach = rs.getString("Masach");
                String tenSach = rs.getString("Tensach");
                String maTheLoai = rs.getString("Matheloai");
                String maTacGia = rs.getString("Matacgia");
                String maNXB = rs.getString("MaNXB");
                float giaSach = rs.getFloat("Giasach");
                int soLuong = rs.getInt("Soluong");
                String anh = rs.getString("Anh");
                String ghiChu = rs.getString("Ghichu");

                Sach sach = new Sach(maSach, tenSach, maTheLoai, maTacGia, maNXB, giaSach, soLuong, anh, ghiChu);
                list.add(sach);
            }

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
