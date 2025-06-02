package controller;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.NhanVienDAO;
import model.Nhanvien;
import model.PermissionLevel;
import utilities.PermissionUtil;
import view.NhanVienForm;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class NhanVienController {
    private NhanVienForm view;
    private NhanVienDAO dao;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public NhanVienController(NhanVienForm view) throws SQLException {
        this.view = view;
        this.dao = new NhanVienDAO();

        // Load dữ liệu ban đầu
        loadTableData();
        clearForm();

        // Gắn sự kiện cho các nút
        view.getBtnThem().addActionListener(e -> themNhanVien());
        view.getBtnLuu().addActionListener(e -> saveNhanVien());
        view.getBtnXoa().addActionListener(e -> deleteNhanVien());
        view.getBtnSua().addActionListener(e -> updateNhanVien());
        view.getBtnBoQua().addActionListener(e -> clearForm());
        view.getBtnTimKiem().addActionListener(e -> searchNhanVien());
        // Giả sử bạn đã có hàm xuất danh sách ra Excel, thêm sự kiện cho nút này
//        view.btnTaoDanhSach.addActionListener(e -> xuatDanhSachRaExcel());

        // Sự kiện khi chọn 1 dòng bảng sẽ hiển thị thông tin lên form
        view.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            	if(!view.getBtnThem().isEnabled())
            	{
            		JOptionPane.showMessageDialog(view, "Bạn đang ở chế độ thêm mới.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            	}
            	view.getBtnBoQua().setEnabled(true);
                if (!e.getValueIsAdjusting()) { // tránh gọi 2 lần
                    int selectedRow = view.getTable().getSelectedRow();
                    if (selectedRow >= 0) {
                        fillFormFromTable(selectedRow);
                    }
                }
            }
        });
    }

    private void loadTableData() {
        List<Nhanvien> list = dao.getAll();
        fillTable(list);
    }

    private void fillTable(List<Nhanvien> list) {
        DefaultTableModel model = view.getModel();
        model.setRowCount(0);
        for (Nhanvien nv : list) {
            model.addRow(new Object[]{
                    nv.getMaNhanVien(),
                    nv.getTenNhanVien(),
                    nv.getDiaChi(),
                    nv.getEmail(),
                    nv.getNgaySinh(),
                    nv.getSDT(),
                    nv.getGioiTinh(),
                    nv.getChucVu()
            });
        }
    }

    private void themNhanVien()
    {
    	if(!PermissionUtil.isAllowedToModify(view.getNv(), view))
    	{
    		return;
    	}
    	
    	clearForm();
    	view.getTxtMaNV().setEditable(true);
    	view.getBtnThem().setEnabled(false);
    	view.getBtnSua().setEnabled(false);
    	view.getBtnXoa().setEnabled(false);
    	view.getBtnTimKiem().setEnabled(false);
    	
    	view.getBtnLuu().setEnabled(true);
    	view.getBtnBoQua().setEnabled(true);
    }
    
    private void saveNhanVien() {
        Nhanvien nv = getFormData();
        if (nv == null) {
            JOptionPane.showMessageDialog(view, "Vui lòng điền đầy đủ thông tin và chọn giới tính.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean success;
        if (dao.selectById(nv.getMaNhanVien()) == null) {
            success = true;
            dao.them(nv);
        } else {
            success = false;
        }

        if (success) {
            JOptionPane.showMessageDialog(view, "Lưu thành công!");
            clearForm();
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(view, "Lưu thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteNhanVien() {
    	if(!PermissionUtil.isAllowedToModify(view.getNv(), view))
    	{
    		return;
    	}
    	
    	
        String maNV = view.getTxtMaNV().getText().trim();
        if (maNV.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập mã nhân viên để xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(maNV.equals(view.getNv().getMaNhanVien()))
        {
        	JOptionPane.showMessageDialog(view, "Bạn không thể xóa thông tin của chính mình", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    	

        int confirm = JOptionPane.showConfirmDialog(view, "Bạn chắc chắn muốn xóa nhân viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int deleted = dao.xoa(maNV);
            if (deleted > 0) {
                JOptionPane.showMessageDialog(view, "Xóa thành công!");
                clearForm();
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(view, "Xóa thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateNhanVien() {
    	if(!PermissionUtil.isAllowedToModify(view.getNv(), view))
    	{
    		return;
    	}
    	
        Nhanvien nv = getFormData();
        if (nv == null) {
            JOptionPane.showMessageDialog(view, "Vui lòng điền đầy đủ thông tin và chọn giới tính.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

//        if (dao.selectById(nv.getMaNhanVien()) == null) {
//            JOptionPane.showMessageDialog(view, "Mã nhân viên không tồn tại để sửa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            return;
//        }

        int success = dao.sua(nv);
        if (success > 0) {
            JOptionPane.showMessageDialog(view, "Sửa thành công!");
            clearForm();
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(view, "Sửa thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchNhanVien() {
        String keyword = JOptionPane.showInputDialog(view, "Nhập từ khóa tìm kiếm (Mã hoặc Tên):");
        if (keyword != null && !keyword.trim().isEmpty()) {
            List<Nhanvien> list = dao.timKiemBangTenOrMa(keyword.trim());
            fillTable(list);
            if(list.size()==0){
                JOptionPane.showMessageDialog(view, "Không tìm được bản ghi phù hợp");
            }
        }
    }

    private void clearForm() {
        view.getTxtMaNV().setText("");
        view.getTxtTenNV().setText("");
        view.getTxtDiaChi().setText("");
        view.getTxtEmail().setText("");
        view.getTxtSDT().setText("");
        view.getTxtChucvu().setText("");
        view.getSpnNgaySinh().setText("");
        view.getRdoNam().setSelected(false);
        view.getRdoNu().setSelected(false);
        view.getTable().clearSelection();
        view.getCboQuyenHan().setSelectedIndex(-1);
        
        view.getTxtMaNV().setEditable(false);
        
        view.getBtnLuu().setEnabled(false);
        view.getBtnBoQua().setEnabled(false);
        
        view.getBtnThem().setEnabled(true);
        
        view.getBtnSua().setEnabled(true);
        view.getBtnXoa().setEnabled(true);
        
        view.getBtnTimKiem().setEnabled(true);
        view.getBtnHienThi().setEnabled(true);
    }

    private Nhanvien getFormData() {
    	
        String ma = view.getTxtMaNV().getText().trim();
        String ten = view.getTxtTenNV().getText().trim();
        String diaChi = view.getTxtDiaChi().getText().trim();
        String email = view.getTxtEmail().getText().trim();
        String sdt = view.getTxtSDT().getText().trim();
        String chucVu = view.getTxtChucvu().getText().trim();
        java.sql.Date ngaySinh;
        try {
        	ngaySinh = java.sql.Date.valueOf(view.getSpnNgaySinh().getText().trim());
		} catch (Exception e) {
			ngaySinh = null;
		}
        
        
        String gioiTinh = view.getRdoNam().isSelected() ? "Nam" : (view.getRdoNu().isSelected() ? "Nữ" : null);
        PermissionLevel quyenHan = PermissionLevel.NONE;
        switch (view.getCboQuyenHan().getSelectedIndex() ) {
		case 0: {
			quyenHan = PermissionLevel.NONE;
			break;
		}
		case 1: {
			quyenHan = PermissionLevel.NHANVIEN;
			break;
		}
		case 2:{
			quyenHan = PermissionLevel.ADMIN;
			break;
		}
			
		}
         

        if (ma.isEmpty() || ten.isEmpty() || diaChi.isEmpty() || email.isEmpty() || sdt.isEmpty() || chucVu.isEmpty() || gioiTinh == null || ngaySinh == null || view.getCboQuyenHan().getSelectedIndex() == -1) {
            return null;
        }
        
        String mk = sdt;
        
        return new Nhanvien(ma, ten, ngaySinh, gioiTinh, diaChi, email, sdt, chucVu, mk, quyenHan);
    }

    private void fillFormFromTable(int row) {
    	NhanVienDAO dao = new NhanVienDAO();
        DefaultTableModel model = view.getModel();

        String maNV = model.getValueAt(row, 0).toString();
        String tenNV = model.getValueAt(row, 1).toString();
        String diaChi = model.getValueAt(row, 2).toString();
        String email = model.getValueAt(row, 3).toString();
        String ngaySinhStr = model.getValueAt(row, 4).toString();
        String sdt = model.getValueAt(row, 5).toString();
        String gioiTinh = model.getValueAt(row, 6).toString();
        String chucVu = model.getValueAt(row, 7).toString();
        PermissionLevel quyenHan = dao.selectById(maNV).getQuyenHan();

        try {
//            java.util.Date ngaySinh = sdf.parse(ngaySinhStr);

            view.getTxtMaNV().setText(maNV);
            view.getTxtTenNV().setText(tenNV);
            view.getTxtDiaChi().setText(diaChi);
            view.getTxtEmail().setText(email);
            view.getSpnNgaySinh().setText(ngaySinhStr);
            view.getTxtSDT().setText(sdt);
            view.getTxtChucvu().setText(chucVu);
            
            switch (quyenHan) {
			case NONE: {
				view.getCboQuyenHan().setSelectedIndex(0);
				break;
			}
			
			case NHANVIEN:{
				view.getCboQuyenHan().setSelectedIndex(1);
				break;
			}
			
			case ADMIN:{
				view.getCboQuyenHan().setSelectedIndex(2);
			}
			}

            if ("Nam".equalsIgnoreCase(gioiTinh)) {
                view.getRdoNam().setSelected(true);
            } else if ("Nữ".equalsIgnoreCase(gioiTinh)) {
                view.getRdoNu().setSelected(true);
            } else {
                view.getRdoNam().setSelected(false);
                view.getRdoNu().setSelected(false);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Lỗi định dạng ngày sinh!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Đây là placeholder nếu bạn muốn implement xuất Excel
    private void xuatDanhSachRaExcel() {
        // TODO: Viết code xuất danh sách nhân viên ra file Excel
        List<Nhanvien> list = dao.getAll();

    // Đổ dữ liệu lên bảng
    fillTable(list);

    // Hiển thị thông báo
    JOptionPane.showMessageDialog(view, "Đã tải danh sách nhân viên đầy đủ lên bảng.");
    }
}
