package Database_Class;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import JDBC_Class.JDBC_Util;
import Model.Nhaxuatban;

public class Nhaxuatban_DB implements GenericDB<Nhaxuatban>{

    public static Nhaxuatban_DB getInstance()
    {
        return new Nhaxuatban_DB();
    }

    @Override
    public int Them(Nhaxuatban t) {
        int ketQua = 0;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String maNXB = t.getMaNXB();
            String tenNXB = t.getTenNXB();
            String diaChi = t.getDiaChi();
            String SDT = t.getSDT();
            String email = t.getEmail();

            String sql = "INSERT INTO tblNXB(MaNXB, TenNXB, Diachi, SDT, Email) VALUES " +
                         "('" + maNXB + "', N'" + tenNXB + "', N'" + diaChi + "', '" + SDT + "', '" + email + "')";

            ketQua = statement.executeUpdate(sql);

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int Sua(Nhaxuatban t) {
        int ketQua = 0;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String maNXB = t.getMaNXB();
            String tenNXB = t.getTenNXB();
            String diaChi = t.getDiaChi();
            String SDT = t.getSDT();
            String email = t.getEmail();

            String sql = "UPDATE tblNXB SET" +
                        " TenNXB = N'" + tenNXB + "'" +
                        ", Diachi = N'" + diaChi + "'" +
                        ", Email = '" + email + "'" +
                        ", SDT = '" + SDT + "'" +
                        " WHERE MaNXB = '" + maNXB + "'";

            ketQua = statement.executeUpdate(sql);

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int Xoa(Nhaxuatban t) {
        int ketQua = 0;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String maNXB = t.getMaNXB();

            String sql = "DELETE FROM tblNXB WHERE MaNXB = '" + maNXB + "'";

            ketQua = statement.executeUpdate(sql);

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Dữ liệu đang được sử dụng bởi 1 bảng khác, không thể xóa", "Lỗi", JOptionPane.WARNING_MESSAGE); 
        }
        return ketQua;
    }

    @Override
    public ArrayList<Nhaxuatban> selectAll() {
        ArrayList<Nhaxuatban> list = new ArrayList<Nhaxuatban>();
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String sql = "SELECT * FROM tblNXB";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next())
            {
                String maNXB = rs.getString("MaNXB");
                String tenNXB = rs.getString("TenNXB");
                String diaChi = rs.getString("Diachi");
                String SDT = rs.getString("SDT");
                String email = rs.getString("Email");

                Nhaxuatban nhaxuatban = new Nhaxuatban(maNXB, tenNXB, diaChi, SDT, email);
                list.add(nhaxuatban);
            }

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Nhaxuatban selectById(String Id) {
        Nhaxuatban nhaxuatban = null;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String sql = "SELECT * FROM tblNXB WHERE Matacgia = '" + Id + "'";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next())
            {
                String maNXB = rs.getString("MaNXB");
                String tenNXB = rs.getString("TenNXB");
                String diaChi = rs.getString("Diachi");
                String SDT = rs.getString("SDT");
                String email = rs.getString("Email");

                nhaxuatban = new Nhaxuatban(maNXB, tenNXB, diaChi, SDT, email);
            }

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhaxuatban;
    }

    @Override
    public ArrayList<Nhaxuatban> selectByCondition(String condition) {
        ArrayList<Nhaxuatban> list = new ArrayList<Nhaxuatban>();
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String sql = "SELECT * FROM tblNXB WHERE " + condition;
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next())
            {
                String maNXB = rs.getString("MaNXB");
                String tenNXB = rs.getString("TenNXB");
                String diaChi = rs.getString("Diachi");
                String SDT = rs.getString("SDT");
                String email = rs.getString("Email");

                Nhaxuatban nhaxuatban = new Nhaxuatban(maNXB, tenNXB, diaChi, SDT, email);
                list.add(nhaxuatban);
            }

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
