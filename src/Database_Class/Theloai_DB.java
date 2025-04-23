package Database_Class;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import JDBC_Class.JDBC_Util;
import Model.Theloai;

public class Theloai_DB implements GenericDB<Theloai>{

    public static Theloai_DB getInstance()
    {
        return new Theloai_DB();
    }

    @Override
    public int Them(Theloai t) {
        int ketQua = 0;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String maTheLoai = t.getMaTheLoai();
            String tenTheLoai = t.getTenTheLoai();

            String sql = "INSERT INTO tblTheLoai(Matheloai, Tentheloai) VALUES " +
                         "('" + maTheLoai + "', N'" + tenTheLoai + "')";

            ketQua = statement.executeUpdate(sql);

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int Sua(Theloai t) {
        int ketQua = 0;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String maTheLoai = t.getMaTheLoai();
            String tenTheLoai = t.getTenTheLoai();

            String sql = "UPDATE tblTheLoai SET" +
                         " Tentheloai = N'" + tenTheLoai + "'" + 
                         " WHERE Matheloai = '" + maTheLoai + "'";

            ketQua = statement.executeUpdate(sql);

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int Xoa(Theloai t) {
        int ketQua = 0;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String maTheLoai = t.getMaTheLoai();
            String tenTheLoai = t.getTenTheLoai();

            String sql = "UPDATE tblTheLoai SET" +
                         " Tentheloai = N'" + tenTheLoai + "'" + 
                         " WHERE Matheloai = '" + maTheLoai + "'";

            ketQua = statement.executeUpdate(sql);

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Dữ liệu đang được sử dụng bởi 1 bảng khác, không thể xóa", "Lỗi", JOptionPane.WARNING_MESSAGE); 
        }
        return ketQua;
    }

    @Override
    public ArrayList<Theloai> selectAll() {
        ArrayList<Theloai> list = new ArrayList<Theloai>();
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String sql = "SELECT * FROM tblTheLoai";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maTheLoai = rs.getString("Matheloai");
                String tenTheLoai = rs.getString("Tentheloai");
                
                Theloai theloai = new Theloai(maTheLoai, tenTheLoai);
                list.add(theloai);
            }

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Theloai selectById(String Id) {
        Theloai theloai = null;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String sql = "SELECT Matheloai FROM tblTheLoai WHERE Mathel";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maTheLoai = rs.getString("Matheloai");
                String tenTheLoai = rs.getString("Tentheloai");
                
                theloai = new Theloai(maTheLoai, tenTheLoai);
            }

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theloai;
    }

    @Override
    public ArrayList<Theloai> selectByCondition(String condition) {
        ArrayList<Theloai> list = new ArrayList<Theloai>();
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String sql = "SELECT * FROM tblTheLoai WHERE " + condition;
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maTheLoai = rs.getString("Matheloai");
                String tenTheLoai = rs.getString("Tentheloai");
                
                Theloai theloai = new Theloai(maTheLoai, tenTheLoai);
                list.add(theloai);
            }

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
