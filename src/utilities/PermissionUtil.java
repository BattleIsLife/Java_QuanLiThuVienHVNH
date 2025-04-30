package utilities;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Nhanvien;
import model.PermissionLevel;

public class PermissionUtil {
	public static boolean isAllowedToModify(Nhanvien nv, JFrame frame)
	{
		if(nv.getQuyenHan() != PermissionLevel.ADMIN)
		{
			JOptionPane.showMessageDialog(frame, "Bạn không có quyền để thực hiện tác vụ trên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	public static boolean isAllowedToView(Nhanvien nv, JFrame frame)
	{
		if(nv.getQuyenHan() != PermissionLevel.ADMIN || nv.getQuyenHan() != PermissionLevel.NHANVIEN)
		{
			JOptionPane.showMessageDialog(frame, "Bạn không có quyền để thực hiện tác vụ trên", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
}
