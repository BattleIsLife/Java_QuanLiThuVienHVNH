package controller;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.NguoiMuonDAO;
import model.Nguoimuon;
import utilities.PermissionUtil;
import view.NguoiMuonForm;

import java.awt.event.*;
import java.sql.Date;
import java.util.List;

public class NguoiMuonController {
    private NguoiMuonForm view;
    private NguoiMuonDAO dao;

    public NguoiMuonController(NguoiMuonForm view) {
        this.view = view;
        this.dao = new NguoiMuonDAO();

        initController();
        loadDataToTable();
        clearForm();
    }

    private void initController() {
        view.getBtnThem().addActionListener(e -> btnThem_Click());
        view.getBtnLuu().addActionListener(e -> insertNguoiMuon());
        view.getBtnXoa().addActionListener(e -> deleteNguoiMuon());
        view.getBtnSua().addActionListener(e -> updateNguoiMuon());
        view.getBtnBoQua().addActionListener(e -> clearForm());
        view.getBtnTimKiem().addActionListener(e -> searchNguoiMuon());
        view.getBtnHienThi().addActionListener(e -> loadDataToTable());

        view.getTable().getSelectionModel().addListSelectionListener(e -> tableSelectionChanged(e));
    }

    private void loadDataToTable() {
        List<Nguoimuon> list = dao.getAll();
        DefaultTableModel model = view.getModel();
        model.setRowCount(0);
        for (Nguoimuon nm : list) {
            model.addRow(new Object[]{
                    nm.getMaNguoiMuon(),
                    nm.getTenNguoiMuon(),
                    nm.getGioiTinh(),
                    nm.getSDT(),
                    nm.getDiaChi(),
                    nm.getEmail()
            });
        }
    }

    private void clearForm() {
        view.getTxtMaNguoiMuon().setText("");
        view.getTxtTenNguoiMuon().setText("");
        view.getTxtDiaChi().setText("");
        view.getTxtEmail().setText("");
        view.getTxtSDT().setText("");
        view.getRdoNam().setSelected(true);
        view.getRdoNu().setSelected(false);
        view.getTable().clearSelection();

        
        view.getTxtMaNguoiMuon().setEditable(false);
        
        view.getBtnLuu().setEnabled(false);
        view.getBtnBoQua().setEnabled(false);
        
        view.getBtnThem().setEnabled(true);
        
        view.getBtnSua().setEnabled(true);
        view.getBtnXoa().setEnabled(true);
        
        view.getBtnTimKiem().setEnabled(true);
        view.getBtnHienThi().setEnabled(true);
    }

    private boolean validateFormInputs() {
        if (view.getTxtMaNguoiMuon().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập Mã người mượn!");
            view.getTxtMaNguoiMuon().requestFocus();
            return false;
        }
        if (view.getTxtTenNguoiMuon().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập Tên người mượn!");
            view.getTxtTenNguoiMuon().requestFocus();
            return false;
        }
        if (view.getTxtDiaChi().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập Địa chỉ!");
            view.getTxtDiaChi().requestFocus();
            return false;
        }
        if (view.getTxtEmail().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập Email!");
            view.getTxtEmail().requestFocus();
            return false;
        }
        if (view.getTxtSDT().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập Số điện thoại!");
            view.getTxtSDT().requestFocus();
            return false;
        }
        return true;
    }

    private Nguoimuon getNguoiMuonFromForm() {
        String ma = view.getTxtMaNguoiMuon().getText().trim();
        String ten = view.getTxtTenNguoiMuon().getText().trim();
        String diaChi = view.getTxtDiaChi().getText().trim();
        String email = view.getTxtEmail().getText().trim();
        String sdt = view.getTxtSDT().getText().trim();
        String gioiTinh = view.getRdoNam().isSelected() ? "Nam" : "Nữ";

        return new Nguoimuon(ma, ten, gioiTinh, sdt, diaChi, email);
    }
    
    private void btnThem_Click()
    {
    	clearForm();
    	view.getTxtMaNguoiMuon().setEditable(true);
        
        view.getBtnLuu().setEnabled(true);
        view.getBtnBoQua().setEnabled(true);
        
        view.getBtnThem().setEnabled(false);
        
        view.getBtnSua().setEnabled(false);
        view.getBtnXoa().setEnabled(false);
        
        view.getBtnTimKiem().setEnabled(false);
        view.getBtnHienThi().setEnabled(false);
    	
    }
    
    private void insertNguoiMuon() {
        if (!validateFormInputs()) return;

        Nguoimuon nm = getNguoiMuonFromForm();
        if (dao.selectById(nm.getMaNguoiMuon()) != null) {
            JOptionPane.showMessageDialog(view, "Mã người mượn đã tồn tại!");
            return;
        }

        if (dao.insert(nm) > 0) {
            JOptionPane.showMessageDialog(view, "Thêm thành công!");
            loadDataToTable();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(view, "Thêm thất bại!");
        }
    }

    private void updateNguoiMuon() {
        if (!validateFormInputs()) return;

        Nguoimuon nm = getNguoiMuonFromForm();
        if (dao.update(nm) > 0) {
            JOptionPane.showMessageDialog(view, "Cập nhật thành công!");
            loadDataToTable();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(view, "Cập nhật thất bại!");
        }
    }

    private void deleteNguoiMuon() {
    	if(!PermissionUtil.isAllowedToModify(view.getNv(), view))
    	{
    		return;
    	}
        String ma = view.getTxtMaNguoiMuon().getText().trim();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng chọn người mượn để xóa!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(view, "Bạn có chắc chắn muốn xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (dao.delete(ma) > 0) {
                JOptionPane.showMessageDialog(view, "Xóa thành công!");
                loadDataToTable();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(view, "Xóa thất bại!");
            }
        }
    }

    private void searchNguoiMuon() {
        String keyword = JOptionPane.showInputDialog(view, "Nhập từ khóa tìm kiếm (Mã hoặc Tên):");
        if (keyword != null && !keyword.trim().isEmpty()) {
            List<Nguoimuon> list = dao.selectByKeyword(keyword);
            DefaultTableModel model = view.getModel();
            model.setRowCount(0);
            for (Nguoimuon nm : list) {
                model.addRow(new Object[]{
                        nm.getMaNguoiMuon(),
                        nm.getTenNguoiMuon(),
                        nm.getGioiTinh(),
                        nm.getSDT(),
                        nm.getDiaChi(),
                        nm.getEmail()
                });
            }
        }
    }

    private void tableSelectionChanged(ListSelectionEvent e) {
    	if(!view.getBtnThem().isEnabled())
    	{
    		JOptionPane.showMessageDialog(view, "Bạn đang ở chế độ thêm mới.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    	}
        int row = view.getTable().getSelectedRow();
        if (row >= 0) {
        	view.getBtnBoQua().setEnabled(true);
            view.getTxtMaNguoiMuon().setText(view.getModel().getValueAt(row, 0).toString());
            view.getTxtTenNguoiMuon().setText(view.getModel().getValueAt(row, 1).toString());
            String gioiTinh = view.getModel().getValueAt(row, 2).toString();
            if (gioiTinh.equalsIgnoreCase("Nam")) {
                view.getRdoNam().setSelected(true);
            } else {
                view.getRdoNu().setSelected(true);
            }
            
            view.getTxtSDT().setText(view.getModel().getValueAt(row, 3).toString());
            view.getTxtDiaChi().setText(view.getModel().getValueAt(row, 4).toString());
            view.getTxtEmail().setText(view.getModel().getValueAt(row, 5).toString());
        }
    }
}
