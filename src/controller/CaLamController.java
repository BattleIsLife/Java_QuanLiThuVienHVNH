package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.CaLamDAO;
import dao.NhanVienDAO;
import model.Calam;
import model.Nhanvien;
import view.CaLamForm;

public class CaLamController {

    private CaLamForm view;
    private CaLamDAO cl_dao = new CaLamDAO();
    private NhanVienDAO nv_dao = new NhanVienDAO();

    public CaLamController(CaLamForm view)
    {
        this.view = view;
        LoadTable();
        LoadComboBox();
        ResetValue();
        cboChanged();

        view.getCboNV().addItemListener(e -> cboChanged());
        view.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                tableClick();
            }
        });

        view.getBtnThem().addActionListener(e -> btnThemClick());
        view.getBtnBoQua().addActionListener(e -> ResetValue());
        view.getBtnLuu().addActionListener(e -> btnLuu());
        view.getBtnSua().addActionListener(e -> btnSua());
        view.getBtnXoa().addActionListener(e -> btnXoa());

        view.getBtnTimKiem().addActionListener(e -> btnTimKiem());
        view.getBtnHienThi().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ResetValue();
                LoadTable();
            }
            
        });

        view.getTxtNgayLam().addKeyListener(new KeyAdapter(){
            @Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!( (c>='0' && c <= '9') || c == '-' || c == '\b') )
					e.consume();
			}
        });
        
    }

    private void LoadTable()
    {
        List<Calam> list = cl_dao.getAll();
        view.getModel().setRowCount(0);
        for (Calam cl : list) {
            Nhanvien nv = nv_dao.selectById(cl.getMaNhanVien());
            Object[] col = {cl.getMaCaLam(), cl.getMaNhanVien(), nv.getTenNhanVien(), cl.getThoiGian()};
            view.getModel().addRow(col);
        }
    }

    private void LoadComboBox()
    {
        List<Nhanvien> list = nv_dao.getAll();
        for (Nhanvien nhanvien : list) {
            view.getCboNV().addItem(nhanvien.getMaNhanVien());
        }
    }

    private void ResetValue()
    {
        view.getTxtMaCa().setEditable(false);
        view.getCboNV().setSelectedIndex(-1);

        view.getBtnThem().setEnabled(true);
        view.getBtnSua().setEnabled(true);
        view.getBtnXoa().setEnabled(true);
        view.getBtnLuu().setEnabled(false);
        view.getBtnBoQua().setEnabled(false);

        view.getBtnTimKiem().setEnabled(true);
        view.getBtnHienThi().setEnabled(true);

        view.getTxtMaCa().setText("");
        view.getTxtNgayLam().setText("");
    }

    private void cboChanged()
    {
        try {
            String ma = view.getCboNV().getSelectedItem().toString();
            view.getTxtHoTen().setText(nv_dao.selectById(ma).getTenNhanVien());    
        } catch (Exception e) {
            view.getTxtHoTen().setText("");
        }
    }

    private void tableClick()
    {
        if(!view.getBtnThem().isEnabled())
        {
            JOptionPane.showMessageDialog(view, "Bạn đang ở chế độ thêm mới", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JTable table = view.getTable();
        int selected_row = table.getSelectedRow();
        if(selected_row>=0)
        {
            view.getTxtMaCa().setText(table.getValueAt(selected_row, 0).toString());
            view.getCboNV().setSelectedItem(table.getValueAt(selected_row, 1).toString());
            view.getTxtHoTen().setText(table.getValueAt(selected_row, 2).toString());
            view.getTxtNgayLam().setText(table.getValueAt(selected_row, 3).toString());
        }
        view.getBtnBoQua().setEnabled(true);
    }

    private void btnThemClick()
    {
        ResetValue();

        view.getBtnLuu().setEnabled(true);
        view.getBtnBoQua().setEnabled(true);

        view.getBtnThem().setEnabled(false);
        view.getBtnSua().setEnabled(false);
        view.getBtnXoa().setEnabled(false);

        view.getBtnTimKiem().setEnabled(false);
        view.getBtnHienThi().setEnabled(false);

        view.getTxtMaCa().setEditable(true);
    }

    private void btnLuu()
    {
        String maca = view.getTxtMaCa().getText().trim();
        String ngay = view.getTxtNgayLam().getText().trim();
        if(maca.isEmpty())
        {
            JOptionPane.showMessageDialog(view, "Mã ca làm không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(view.getCboNV().getSelectedItem() == null)
        {
            JOptionPane.showMessageDialog(view, "Mã nhân viên không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String manv = view.getCboNV().getSelectedItem().toString().trim();

        if(ngay.isEmpty())
        {
            JOptionPane.showMessageDialog(view, "Ngày làm không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!utilities.DateTimeUtil.isDate(ngay, view))
        {
            return;
        }
        
        Nhanvien nv = nv_dao.selectById(manv);
        if(nv == null)
        {
            JOptionPane.showMessageDialog(view, "Nhân viên không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Calam calam = cl_dao.selectById(maca);
        if(calam != null)
        {
            JOptionPane.showMessageDialog(view, "Trùng mã ca làm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cl_dao.insert(new Calam(maca, manv, Date.valueOf(ngay)));
        ResetValue();
        LoadTable();
    }

    private void btnSua()
    {
        String maca = view.getTxtMaCa().getText().trim();
        String ngay = view.getTxtNgayLam().getText().trim();
        if(maca.isEmpty())
        {
            JOptionPane.showMessageDialog(view, "Vui lòng chọn dữ liệu để sửa", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(view.getCboNV().getSelectedItem() == null)
        {
            JOptionPane.showMessageDialog(view, "Mã nhân viên không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String manv = view.getCboNV().getSelectedItem().toString().trim();

        if(ngay.isEmpty())
        {
            JOptionPane.showMessageDialog(view, "Ngày làm không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!utilities.DateTimeUtil.isDate(ngay, view))
        {
            return;
        }
        
        Nhanvien nv = nv_dao.selectById(manv);
        if(nv == null)
        {
            JOptionPane.showMessageDialog(view, "Nhân viên không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cl_dao.update(new Calam(maca, manv, Date.valueOf(ngay)));
        ResetValue();
        LoadTable();
    }

    private void btnXoa()
    {
        String maca = view.getTxtMaCa().getText().trim();
        if(maca.isEmpty())
        {
            JOptionPane.showMessageDialog(view, "Vui lòng chọn dữ liệu để xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(JOptionPane.showConfirmDialog(view, "Xóa dữ liệu này?", "Xóa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
        {
            cl_dao.delete(maca);
            ResetValue();
            LoadTable();
        }
    }

    private void btnTimKiem()
    {
        String manv = "";
        String ngay = "";
        if(view.getCboNV().getSelectedItem() == null && view.getTxtNgayLam().getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập đủ điều kiện tìm kiếm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String sql = "SELECT * FROM tblCaLam WHERE 1=1 ";

        if(view.getCboNV().getSelectedItem() != null)
        {
            manv = view.getCboNV().getSelectedItem().toString();
            sql += "AND Manhanvien = '" + manv + "' ";
        }

        if(!view.getTxtNgayLam().getText().trim().isEmpty())
        {
            ngay = view.getTxtNgayLam().getText().trim();
            sql += "AND Thoigian = '" + ngay + "' ";
        }

        
        DefaultTableModel model = view.getModel();  
        try {
            List<Calam> list = cl_dao.getAll(sql);
            if(list.size() == 0)
            {
                model.setRowCount(0);
                JOptionPane.showMessageDialog(view, "Không có dòng nào thỏa mãn điều kiện tìm kiếm", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            }
            else
            {
                model.setRowCount(0);
                for (Calam cl : list) {
                    Nhanvien nv = nv_dao.selectById(cl.getMaNhanVien());
                    Object[] col = {cl.getMaCaLam(), cl.getMaNhanVien(), nv.getTenNhanVien(), cl.getThoiGian()};
                    view.getModel().addRow(col);
                }
                JOptionPane.showMessageDialog(view, "Có " + list.size() + " dòng thỏa mãn điều kiện tìm kiếm", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (Exception e) {
            model.setRowCount(0);
            JOptionPane.showMessageDialog(view, "Không có dòng nào thỏa mãn điều kiện tìm kiếm", "Thông báo", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
