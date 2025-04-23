package Database_Class;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import JDBC_Class.JDBC_Util;
import Model.Nhanvien;
import Model.Nhanvien.PermissionLevel;

public class Nhanvien_DB implements GenericDB<Nhanvien>{

    public static Nhanvien_DB getInstance()
    {
        return new Nhanvien_DB();
    }

    @Override
    public int Them(Nhanvien t) {
        int ketQua = 0;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String maNhanVien = t.getMaNhanVien();
            String tenNhanVien = t.getTenNhanVien();
            Date ngaySinh = t.getNgaySinh();
            String gioiTinh = t.getGioiTinh();
            String diaChi = t.getDiaChi();
            String email = t.getEmail();
            String SDT = t.getSDT();
            String chucVu = t.getChucVu();
            String matKhau = t.getMatKhau();
            PermissionLevel quyenHan = t.getQuyenHan();

            String sql = "INSERT INTO tblNhanVien(Manhanvien, Tennhanvien, Ngaysinh, Gioitinh, Diachi, Email, SDT, Chucvu, Matkhau, Quyenhan) VALUES " +
                         "('" + maNhanVien + "', N'" + tenNhanVien + "', '" + ngaySinh + "', N'" + gioiTinh + "', N'" + diaChi + "', '" + email + "', '" + SDT + "', N'" + chucVu + "', '" + matKhau + "', '" + quyenHan + "')";

            ketQua = statement.executeUpdate(sql);

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int Sua(Nhanvien t) {
        int ketQua = 0;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String maNhanVien = t.getMaNhanVien();
            String tenNhanVien = t.getTenNhanVien();
            Date ngaySinh = t.getNgaySinh();
            String gioiTinh = t.getGioiTinh();
            String diaChi = t.getDiaChi();
            String email = t.getEmail();
            String SDT = t.getSDT();
            String chucVu = t.getChucVu();
            String matKhau = t.getMatKhau();
            PermissionLevel quyenHan = t.getQuyenHan();

            String sql = "UPDATE tblNhanVien SET" +
                        " Tennhanvien = N'" + tenNhanVien + "'" +
                        ", Ngaysinh = '" + ngaySinh + "'" +
                        ", Gioitinh = N'" + gioiTinh + "'" +
                        ", Diachi = N'" + diaChi + "'" +
                        ", Email = '" + email + "'" +
                        ", SDT = '" + SDT + "'" +
                        ", Chucvu = N'" + chucVu + "'" +
                        ", Matkhau = '" + matKhau + "'" +
                        ", Quyenhan = '" + quyenHan + "'" +
                        " WHERE Manhanvien = '" + maNhanVien + "'";

            ketQua = statement.executeUpdate(sql);

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int Xoa(Nhanvien t) {
        int ketQua = 0;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String maNhanVien = t.getMaNhanVien();

            String sql = "DELETE FROM tblNhanVien WHERE Manhanvien = '" + maNhanVien + "'";

            ketQua = statement.executeUpdate(sql);

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Dữ liệu đang được sử dụng bởi 1 bảng khác, không thể xóa", "Lỗi", JOptionPane.WARNING_MESSAGE); 
        }
        return ketQua;
    }

    @Override
    public ArrayList<Nhanvien> selectAll() {
        ArrayList<Nhanvien> list = new ArrayList<Nhanvien>();
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String sql = "SELECT * FROM tblNhanVien";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next())
            {
                String maNhanVien = rs.getString("Manhanvien");
                String tenNhanVien = rs.getString("Tennhanvien");
                Date ngaySinh = rs.getDate("Ngaysinh");
                String gioiTinh = rs.getString("Gioitinh");
                String diaChi = rs.getString("Diachi");
                String email = rs.getString("Email");
                String SDT = rs.getString("SDT");
                String chucVu = rs.getString("Chucvu");
                String matKhau = rs.getString("Matkhau");
                PermissionLevel quyenHan = PermissionLevel.valueOf(rs.getString("Quyenhan"));

                Nhanvien nhanvien = new Nhanvien(maNhanVien, tenNhanVien, ngaySinh, gioiTinh, diaChi, email, SDT, chucVu, matKhau, quyenHan);
                list.add(nhanvien);
            }

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Nhanvien selectById(String Id) {
        Nhanvien nhanvien = null;
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String sql = "SELECT * FROM tblNhanVien WHERE Manhanvien = '" + Id + "'";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next())
            {
                String maNhanVien = rs.getString("Manhanvien");
                String tenNhanVien = rs.getString("Tennhanvien");
                Date ngaySinh = rs.getDate("Ngaysinh");
                String gioiTinh = rs.getString("Gioitinh");
                String diaChi = rs.getString("Diachi");
                String email = rs.getString("Email");
                String SDT = rs.getString("SDT");
                String chucVu = rs.getString("Chucvu");
                String matKhau = rs.getString("Matkhau");
                PermissionLevel quyenHan = PermissionLevel.valueOf(rs.getString("Quyenhan"));

                nhanvien = new Nhanvien(maNhanVien, tenNhanVien, ngaySinh, gioiTinh, diaChi, email, SDT, chucVu, matKhau, quyenHan);
            }

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanvien;
    }

    @Override
    public ArrayList<Nhanvien> selectByCondition(String condition) {
        ArrayList<Nhanvien> list = new ArrayList<Nhanvien>();
        try {
            Connection c = JDBC_Util.getConnection();
            Statement statement = c.createStatement();

            String sql = "SELECT * FROM tblNhanVien WHERE " + condition;
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next())
            {
                String maNhanVien = rs.getString("Manhanvien");
                String tenNhanVien = rs.getString("Tennhanvien");
                Date ngaySinh = rs.getDate("Ngaysinh");
                String gioiTinh = rs.getString("Gioitinh");
                String diaChi = rs.getString("Diachi");
                String email = rs.getString("Email");
                String SDT = rs.getString("SDT");
                String chucVu = rs.getString("Chucvu");
                String matKhau = rs.getString("Matkhau");
                PermissionLevel quyenHan = PermissionLevel.valueOf(rs.getString("Quyenhan"));

                Nhanvien nhanvien = new Nhanvien(maNhanVien, tenNhanVien, ngaySinh, gioiTinh, diaChi, email, SDT, chucVu, matKhau, quyenHan);
                list.add(nhanvien);
            }

            JDBC_Util.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
