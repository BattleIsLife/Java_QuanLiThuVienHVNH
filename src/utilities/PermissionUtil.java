package utilities;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Nhanvien;
import model.PermissionLevel;

public class PermissionUtil {
	public static boolean isAllowedToModify(Nhanvien nv, JPanel panel)
	{
		if(nv.getQuyenHan() != PermissionLevel.ADMIN)
		{
			JOptionPane.showMessageDialog(panel, "Bạn không có quyền để thực hiện tác vụ trên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static boolean isAllowedToViewAsAdmin(Nhanvien nv, JPanel panel)
	{
		if(nv.getQuyenHan() != PermissionLevel.ADMIN)
		{
			panel.setLayout(new BorderLayout());
			JLabel label = new JLabel("Bạn không có quyền vào xem mục này");
			label.setFont(new Font("Adwaita Sans", Font.BOLD, 30));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(label, BorderLayout.CENTER);
			return false;
		}
		return true;
	}
	
	public static boolean isAllowedToViewAsNhanvien(Nhanvien nv, JPanel panel)
	{
		if(nv.getQuyenHan() == PermissionLevel.ADMIN || nv.getQuyenHan() == PermissionLevel.NHANVIEN)
		{
			return true;
		}

		panel.setLayout(new BorderLayout());
		JLabel label = new JLabel("Bạn không có quyền vào xem mục này");
		label.setFont(new Font("Adwaita Sans", Font.BOLD, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label, BorderLayout.CENTER);
		return false;
	}
}
