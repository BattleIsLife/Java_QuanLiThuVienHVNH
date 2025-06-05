package utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import config.DBConnection;

public class ComboBoxUtil {
	public static void Combobox_GetValue(JComboBox<String> cbo, String sql, String ten) {
		Connection c = DBConnection.getConnection();
		try {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				cbo.addItem(rs.getString(ten));
			}
			DBConnection.closeConnection(c);
		} catch (SQLException e) {

		}
	}
}
