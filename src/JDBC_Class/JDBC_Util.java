package JDBC_Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Util {
    public static JDBC_Util getInstance()
    {
        return new JDBC_Util();
    }

    public static Connection getConnection()
    {
        Connection c = null;

        try {
            String url = "jdbc:mysql://localhost:3306/QuanLiThuVienHVNH";
            String username = "root";
            String password = "27092004";
            c = DriverManager.getConnection(url, username, password);
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại");
            e.printStackTrace();
        }
        return c;
    }

    public static void closeConnection(Connection c)
    {
        try {
            if (c != null)
            System.out.println("Đóng kết nối");
                c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
