import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import JDBC_Class.JDBC_Util;

public class App {
    public static void main(String[] args) throws Exception {
        Connection c = JDBC_Util.getConnection();
        Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM tblTheLoai");
        while (rs.next()) {
            String maTL = rs.getString("Matheloai");
            String TenTL = rs.getString("Tentheloai");
            System.out.printf("%s, %s\n", maTL, TenTL);
        }
        JDBC_Util.closeConnection(c);
    }
}
