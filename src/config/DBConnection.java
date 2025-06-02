package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/QuanLiThuVienHVNH";
    private static final String USER_NAME = "root";
    private static final String PASS_WORD = "123456";

    public static Connection getConnection() {
        Connection c = null;
        try {
            c = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
        } catch (SQLException e) {
            // System.out.println("Kết nối CSDL thất bại!");
            e.printStackTrace();
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null && !c.isClosed()) {
                c.close();
                // System.out.println("Đã đóng kết nối CSDL.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
