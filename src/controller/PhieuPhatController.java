package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.NguoiMuonDAO;
import dao.NhanVienDAO;
import dao.PhieuPhatDAO;
import model.Nguoimuon;
import model.Nhanvien;
import model.PermissionLevel;
import model.Phieuphat;
import utilities.ComboBoxUtil;
import utilities.PermissionUtil;
import view.PhieuPhatForm;

public class PhieuPhatController {
	private PhieuPhatForm view;
	private Nhanvien nv;
	private NguoiMuonDAO nm_dao = new NguoiMuonDAO();
	private NhanVienDAO nv_dao = new NhanVienDAO();
	private PhieuPhatDAO pp_dao = new PhieuPhatDAO();
	
	public PhieuPhatController(PhieuPhatForm view)
	{
		this.view = view;
		nv = view.getNhanvien();
		LoadTable();
		ComboBoxUtil.Combobox_GetValue(view.getCboNguoiMuon(), "SELECT * FROM tblNguoiMuon", "Tennguoimuon");
		ResetValue();

		view.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClick();
			}
		});

		view.getBtnThem().addActionListener(e -> btnThem());
		view.getBtnSua().addActionListener(e -> btnSua());
		view.getBtnXoa().addActionListener(e -> btnXoa());
		view.getBtnLuu().addActionListener(e -> btnLuu());
		view.getBtnBoQua().addActionListener(e -> ResetValue());

		view.getBtnTimKiem().addActionListener(e -> btnTimKiem());
		view.getBtnHienThi().addActionListener(e -> btnHienThi());

	}

	private void ResetValue()
	{
		view.getTxtMaPhieu().setText("");
		view.getTxtNV().setText(view.getNhanvien().getTenNhanVien());
		view.getTxtThoiGian().setText("");
		view.getCboNguoiMuon().setSelectedIndex(-1);
		view.getSpnTienPhat().setValue(Float.valueOf(0));
		view.getTxtGhiChu().setText("");

		view.getCboNguoiMuon().setSelectedIndex(-1);

		view.getTxtThoiGian().setEditable(false);

		view.getBtnThem().setEnabled(true);
		view.getBtnSua().setEnabled(true);
		view.getBtnXoa().setEnabled(true);
		view.getBtnLuu().setEnabled(false);
		view.getBtnBoQua().setEnabled(false);

		view.getBtnTimKiem().setEnabled(true);
		view.getBtnHienThi().setEnabled(true);
	}

	// String[] column = {"Mã phiếu phạt", "Người mượn", "Nhân viên", "Thời gian phạt", "Tiền phạt"};
	private void LoadTable()
	{
		DefaultTableModel model = view.getModel();
		model.setRowCount(0);
		List<Phieuphat> list = pp_dao.getAll();
		for (Phieuphat phieuphat : list) {
			Nhanvien nv = nv_dao.selectById(phieuphat.getMaNhanVien());
			Nguoimuon nm = nm_dao.selectById(phieuphat.getMaNguoiMuon());

			Object[] column = {phieuphat.getMaPhieuPhat(), nm.getTenNguoiMuon(), nv.getTenNhanVien(), phieuphat.getThoiGianPhat(), phieuphat.getTienPhat()};
			model.addRow(column);
		}
	}

	private void tableClick()
	{
		JTable table = view.getTable();
		int row = table.getSelectedRow();

		if(!view.getBtnThem().isEnabled())
		{
			JOptionPane.showMessageDialog(view, "Bạn đang ở chế độ thêm mới.", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if(row >= 0)
		{
			view.getTxtMaPhieu().setText(table.getValueAt(row, 0).toString());
			view.getCboNguoiMuon().setSelectedItem(table.getValueAt(row, 1).toString());
			view.getTxtNV().setText(table.getValueAt(row, 2).toString());
			view.getTxtThoiGian().setText(table.getValueAt(row, 3).toString());

			view.getSpnTienPhat().setValue((Float)table.getValueAt(row, 4));

			view.getTxtGhiChu().setText(pp_dao.selectById(view.getTxtMaPhieu().getText()).getGhiChu());
		}
		view.getBtnBoQua().setEnabled(true);
	}

	private void btnThem()
	{
		ResetValue();

		view.getBtnThem().setEnabled(false);
		view.getBtnSua().setEnabled(false);
		view.getBtnXoa().setEnabled(false);
		view.getBtnLuu().setEnabled(true);
		view.getBtnBoQua().setEnabled(true);

		view.getBtnTimKiem().setEnabled(false);
		view.getBtnHienThi().setEnabled(false);

		

		String manv = view.getNhanvien().getMaNhanVien();
		LocalDateTime dt = LocalDateTime.now();
		view.getTxtThoiGian().setText(Timestamp.valueOf(dt).toString());
		String maphieu = "PP_" + manv + "_" + dt.getYear() + dt.getMonthValue() + dt.getDayOfMonth() + dt.getHour() + dt.getMinute() + dt.getSecond();

		view.getTxtMaPhieu().setText(maphieu);
	}

	private void btnLuu()
	{
		if(getFormValue() != null)
		{
			pp_dao.insert(getFormValue());
			ResetValue();
			LoadTable();
		}
			
	}

	private void btnSua()
	{
		if(view.getTxtMaPhieu().getText().isBlank())
		{
			JOptionPane.showMessageDialog(view, "Bạn chưa chọn dữ liệu để sửa", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if(view.getNhanvien().getQuyenHan() != PermissionLevel.ADMIN && !view.getNhanvien().getMaNhanVien().equals(view.getTxtNV().getText()))
		{
			JOptionPane.showMessageDialog(view, "Bạn không có quyền sửa của người khác", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if(getFormValue() != null)
		{
			pp_dao.update(getFormValue());
			ResetValue();
			LoadTable();
		}
	}

	private void btnXoa()
	{
		if(!PermissionUtil.isAllowedToModify(nv, view))
		{
			return;
		}

		if(view.getTxtMaPhieu().getText().isBlank())
		{
			JOptionPane.showMessageDialog(view, "Bạn chưa chọn dữ liệu để xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if(JOptionPane.showConfirmDialog(view, "Bạn có muốn xóa dữ liệu này", "Xóa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
		{
			pp_dao.delete(view.getTxtMaPhieu().getText());
			ResetValue();
			LoadTable();
		}
	}

	private void btnTimKiem()
	{
		String input = JOptionPane.showInputDialog(view, "Tìm kiếm theo tên nhân viên, tên người mượn", "Tìm kiếm");
		if(input != null)
		{
			String sql = "SELECT Maphieuphat, Tienphat, pm.Manguoimuon, pm.Manhanvien, Thoigianphat, Ghichu FROM tblPhieuPhat pm " + 
			"JOIN tblNhanVien nv ON pm.Manhanvien = nv.Manhanvien JOIN tblNguoiMuon nm ON pm.Manguoimuon = nm.Manguoimuon " + 
			"WHERE nv.Tennhanvien LIKE CONCAT('%', ?, '%') OR nm.Tennguoimuon LIKE CONCAT('%', ?, '%')";

			DefaultTableModel model = view.getModel();
			model.setRowCount(0);
			List<Phieuphat> list = pp_dao.getAll(sql, input, input);
			for (Phieuphat phieuphat : list) {
				Nhanvien nv = nv_dao.selectById(phieuphat.getMaNhanVien());
				Nguoimuon nm = nm_dao.selectById(phieuphat.getMaNguoiMuon());

				Object[] column = {phieuphat.getMaPhieuPhat(), nm.getTenNguoiMuon(), nv.getTenNhanVien(), phieuphat.getThoiGianPhat(), phieuphat.getTienPhat()};
				model.addRow(column);
			}

			JOptionPane.showMessageDialog(view, "Có " + list.size() + " dòng thỏa mãn điều kiện", "Thông báo", JOptionPane.PLAIN_MESSAGE);
		}
	}

	private void btnHienThi()
	{
		ResetValue();
		LoadTable();
	}

	private Phieuphat getFormValue()
	{
		if(view.getCboNguoiMuon().getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(view, "Bạn chưa chọn người mượn", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		String tennguoimuon = view.getCboNguoiMuon().getSelectedItem().toString();
		String ghichu = view.getTxtGhiChu().getText().trim();

		if(ghichu.isEmpty())
		{
			JOptionPane.showMessageDialog(view, "Bạn chưa nhập ghi chú", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		String maphieu = view.getTxtMaPhieu().getText();
		String manv = view.getNhanvien().getMaNhanVien();
		String manguoimuon = nm_dao.selectByTen(tennguoimuon).getMaNguoiMuon();
		Timestamp thoigian = Timestamp.valueOf(view.getTxtThoiGian().getText());
		float tienphat = (float)view.getSpnTienPhat().getValue();

		return new Phieuphat(maphieu, tienphat, manguoimuon, manv, thoigian, ghichu);
	}
}
