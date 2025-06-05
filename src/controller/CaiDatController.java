package controller;

import javax.swing.JOptionPane;

import dao.NhanVienDAO;
import model.Nhanvien;
import view.CaiDatForm;
import view.LoginForm;

public class CaiDatController {
	private CaiDatForm view;
	private NhanVienDAO dao = new NhanVienDAO();
	
	public CaiDatController(CaiDatForm view)
	{
		this.view = view;
		LoadInfo();
		view.getChkHienthi().addActionListener(e -> TogglePassword());
		view.getBtnLuu().addActionListener(e -> btnLuu());
		view.getBtnBoQua().addActionListener(e -> LoadInfo());
		view.getBtnDangxuat().addActionListener(e -> btnDangXuat());
	}
	
	private void LoadInfo()
	{
		String ma = view.getNv().getMaNhanVien();
		Nhanvien nv = dao.selectById(ma);
		view.getTxtMaNV().setText(nv.getMaNhanVien());
		view.getTxtTenNV().setText(nv.getTenNhanVien());
		view.getTxtDiaChi().setText(nv.getDiaChi());
		view.getTxtEmail().setText(nv.getEmail());
		view.getTxtSDT().setText(nv.getSDT());
		view.getSpnNgaySinh().setText(nv.getNgaySinh().toString());
		
		if(nv.getGioiTinh().equals("Nam"))
			view.getRdoNam().setSelected(true);
		else
			view.getRdoNu().setSelected(true);
		
		switch (nv.getQuyenHan()) {
		
		case ADMIN:
			view.getCboQuyenHan().setSelectedIndex(2);
			break;
		case NHANVIEN:
			view.getCboQuyenHan().setSelectedIndex(1);
			break;
		default:
			view.getCboQuyenHan().setSelectedIndex(0);
			break;
		}
		
		view.getTxtChucvu().setText(nv.getChucVu());
		view.getTxtMatkhau().setText(nv.getMatKhau());
	}
	
	private void TogglePassword()
	{
		if(view.getChkHienthi().isSelected())
		{
			view.getTxtMatkhau().setEchoChar((char) 0);
		}
		else
			view.getTxtMatkhau().setEchoChar('•');
	}
	
	private void btnLuu()
	{
		String manv = view.getTxtMaNV().getText();
		String diachi = view.getTxtDiaChi().getText().trim();
		String email = view.getTxtEmail().getText().trim();
		String sdt = view.getTxtSDT().getText().trim();
		char[] c = view.getTxtMatkhau().getPassword();
		String mk = "";
		for(int i = 0; i<c.length; i++)
			mk += c[i];
		
		if(diachi.isEmpty())
		{
			JOptionPane.showMessageDialog(view, "Vui lòng nhập địa chỉ");
			return;
		}
		if(email.isEmpty())
		{
			JOptionPane.showMessageDialog(view, "Vui lòng nhập Email");
			return;
		}
		
		if(sdt.isEmpty() || (sdt.length() > 11 || sdt.length() < 10))
		{
			JOptionPane.showMessageDialog(view, "SĐT đang được để trống hoặc không hợp lệ");
			return;
		}
		
		if(mk.isEmpty())
		{
			JOptionPane.showMessageDialog(view, "Vui lòng nhập mật khẩu");
			return;
		}
		
		String sql = "UPDATE tblNhanVien SET Diachi = ?, Email = ?, SDT = ?, Matkhau = ? WHERE Manhanvien = ?";
		
		dao.update(sql, diachi, email, sdt, mk, manv);
		JOptionPane.showMessageDialog(view, "Cập nhật thông tin thành công");
		LoadInfo();
		
	}
	
	private void btnDangXuat()
	{
		if(JOptionPane.showConfirmDialog(view, "Bạn có muốn đăng xuất", "Đăng xuất", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
		{
			new LoginForm();
			view.getMainGUI().dispose();
		}
	}
	
}
