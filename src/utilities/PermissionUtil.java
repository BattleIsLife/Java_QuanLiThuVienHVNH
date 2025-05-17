package utilities;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
	
	public static boolean isAllowedToView(Nhanvien nv, JPanel panel)
	{
		if(nv.getQuyenHan() != PermissionLevel.ADMIN || nv.getQuyenHan() != PermissionLevel.NHANVIEN)
		{
			JOptionPane.showMessageDialog(panel, "Bạn không có quyền để thực hiện tác vụ trên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
}
