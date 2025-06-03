package view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatLightLaf;
import dao.ChiTietPhieuMuonDAO;
import model.ChiTietPhieuMuonModel;
import model.ChiTietPhieuMuonDTO;
import model.Nhanvien;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ChiTietPhieuMuonForm extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel model;
    private Nhanvien Nhanvien;
    private JTextField txtMaPhieuMuon;
    private JTextField txtMaSach; // Changed to MaSach for clarity
    private JTextField txtSoLuong;

    private JButton btnThem;
    private JButton btnLuu;
    private JButton btnBoQua;
    private JButton btnSua;
    private JButton btnXoa;

    public ChiTietPhieuMuonForm(Nhanvien Nhanvien) {
        this.Nhanvien = Nhanvien;
        FlatLightLaf.setup();
        setSize(1051, 581);
        setBorder(null);
        setLayout(null);

        JLabel lblMaPhieuMuon = new JLabel("Mã phiếu mượn");
        lblMaPhieuMuon.setBounds(22, 14, 120, 23);
        lblMaPhieuMuon.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
        add(lblMaPhieuMuon);

        txtMaPhieuMuon = new JTextField();
        txtMaPhieuMuon.setBounds(142, 10, 309, 31);
        txtMaPhieuMuon.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
        txtMaPhieuMuon.setColumns(10);
        add(txtMaPhieuMuon);

        JLabel lblMaSach = new JLabel("Mã sách");
        lblMaSach.setBounds(512, 14, 120, 23);
        lblMaSach.setHorizontalAlignment(SwingConstants.LEFT);
        lblMaSach.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
        add(lblMaSach);

        txtMaSach = new JTextField();
        txtMaSach.setBounds(642, 10, 309, 31);
        txtMaSach.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
        txtMaSach.setColumns(10);
        add(txtMaSach);

        JLabel lblSoLuong = new JLabel("Số lượng sách");
        lblSoLuong.setBounds(512, 65, 120, 23);
        lblSoLuong.setHorizontalAlignment(SwingConstants.LEFT);
        lblSoLuong.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
        add(lblSoLuong);

        txtSoLuong = new JTextField();
        txtSoLuong.setBounds(642, 61, 309, 31);
        txtSoLuong.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
        txtSoLuong.setColumns(10);
        add(txtSoLuong);

        String[] col = { "Mã phiếu mượn", "Mã sách", "Tên sách", "Số lượng" };
        model = new DefaultTableModel(null, col);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 155, 962, 317);
        add(scrollPane);

        table = new JTable(model);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                table_Click();
            }
        });
        table.setCellSelectionEnabled(true);
        table.setDefaultEditor(Object.class, null);
        table.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
        table.setBorder(new EmptyBorder(1, 1, 1, 1));
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        scrollPane.setViewportView(table);

        JPanel panel = new JPanel();
        panel.setBounds(50, 501, 962, 33);
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setVgap(0);
        flowLayout.setHgap(20);
        add(panel);

        btnThem = new JButton("Thêm");
        btnThem.setBackground(Color.WHITE);
        btnThem.setFont(new Font("Adwaita Sans", Font.PLAIN, 20));
        btnThem.addActionListener(e -> btnThem_Click());
        panel.add(btnThem);

        btnSua = new JButton("Sửa");
        btnSua.setBackground(Color.WHITE);
        btnSua.setFont(new Font("Adwaita Sans", Font.PLAIN, 20));
        btnSua.addActionListener(e -> btnSua_Click());
        panel.add(btnSua);

        btnXoa = new JButton("Xóa");
        btnXoa.setBackground(Color.WHITE);
        btnXoa.setFont(new Font("Adwaita Sans", Font.PLAIN, 20));
        btnXoa.addActionListener(e -> btnXoa_Click());
        panel.add(btnXoa);

        btnLuu = new JButton("Lưu");
        btnLuu.setBackground(Color.WHITE);
        btnLuu.setFont(new Font("Adwaita Sans", Font.PLAIN, 20));
        btnLuu.addActionListener(e -> btnLuu_Click());
        panel.add(btnLuu);

        btnBoQua = new JButton("Bỏ qua");
        btnBoQua.setBackground(Color.WHITE);
        btnBoQua.setFont(new Font("Adwaita Sans", Font.PLAIN, 20));
        btnBoQua.addActionListener(e -> btnBoQua_Click());
        panel.add(btnBoQua);

        JButton btnTimKiem = new JButton("Tìm kiếm");
        btnTimKiem.setBackground(Color.WHITE);
        btnTimKiem.setFont(new Font("Adwaita Sans", Font.PLAIN, 20));
        btnTimKiem.addActionListener(e -> btnTimKiem_Click());
        panel.add(btnTimKiem);

        JButton btnReset = new JButton("Tải lại dữ liệu");
        btnReset.setBackground(Color.WHITE);
        btnReset.setFont(new Font("Adwaita Sans", Font.PLAIN, 20));
        btnReset.addActionListener(e -> btnReset_Click());
        panel.add(btnReset);

        FormLoad();
        SwingUtilities.updateComponentTreeUI(this);
        setVisible(true);
    }

    private void FormLoad() {
        ResetValue();
        GetData(model);
    }

    private void ResetValue() {
        txtMaPhieuMuon.setEnabled(false);
        txtMaPhieuMuon.setText("");
        txtMaSach.setText("");
        txtSoLuong.setText("");
        btnThem.setEnabled(true);
        btnLuu.setEnabled(false);
        btnBoQua.setEnabled(false);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
    }

    private void GetData(DefaultTableModel model) {
        ChiTietPhieuMuonDAO dao = new ChiTietPhieuMuonDAO();
        int rowNum = model.getRowCount();
        for (int i = rowNum - 1; i >= 0; i--)
            model.removeRow(i);

        List<ChiTietPhieuMuonDTO> list = dao.getAll();
        for (ChiTietPhieuMuonDTO pm : list) {
            Object[] row = {
                    pm.getMaphieumuon(),
                    pm.getMasach(),
                    pm.getTensach(),
                    pm.getSoluongmuon()
            };
            model.addRow(row);
        }
    }

    private void table_Click() {
        if (!btnThem.isEnabled()) {
            JOptionPane.showMessageDialog(this, "Bạn đang ở chế độ thêm mới", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có dữ liệu", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            txtMaPhieuMuon.setText(model.getValueAt(selectedRow, 0).toString());
            txtMaSach.setText(model.getValueAt(selectedRow, 1).toString());
            txtSoLuong.setText(model.getValueAt(selectedRow, 3).toString());
            btnBoQua.setEnabled(true);
        }
    }

    private void btnThem_Click() {
        if (!utilities.PermissionUtil.isAllowedToModify(Nhanvien, this))
            return;
        ResetValue();
        txtMaPhieuMuon.setText("");
        txtMaPhieuMuon.setEnabled(true);
        txtMaSach.setText("");
        txtSoLuong.setText("");

        btnThem.setEnabled(false);
        btnLuu.setEnabled(true);
        btnBoQua.setEnabled(true);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
    }

    private void btnBoQua_Click() {
        ResetValue();
    }

    private void btnLuu_Click() {
        String maPhieuMuon = txtMaPhieuMuon.getText().trim();
        String maSach = txtMaSach.getText().trim();
        String soLuongStr = txtSoLuong.getText().trim();

        if (maPhieuMuon.isEmpty() || maPhieuMuon.equals("AUTO")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã phiếu mượn", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (maSach.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (soLuongStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập số lượng sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int soLuong;
        try {
            soLuong = Integer.parseInt(soLuongStr);
            if (soLuong <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ChiTietPhieuMuonDAO dao = new ChiTietPhieuMuonDAO();
        if (!dao.checkBookAvailability(maSach, soLuong)) {
            JOptionPane.showMessageDialog(this, "Số lượng sách không đủ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ChiTietPhieuMuonModel existing = dao.selectById(maPhieuMuon);
        if (existing != null) {
            JOptionPane.showMessageDialog(this, "Trùng mã phiếu mượn", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ChiTietPhieuMuonModel ctpmm = new ChiTietPhieuMuonModel();
        ctpmm.setMaphieumuon(maPhieuMuon);
        ctpmm.setMasach(maSach);
        ctpmm.setSoluongmuon(soLuong);
        dao.them(ctpmm);
        dao.updateBookQuantity(maSach, soLuong, true);
        ResetValue();
        GetData(model);
    }

    private void btnXoa_Click() {
        if (!utilities.PermissionUtil.isAllowedToModify(Nhanvien, this))
            return;
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có dữ liệu", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        String maPhieuMuon = txtMaPhieuMuon.getText().trim();
        String maSach = txtMaSach.getText().trim();
        if (maPhieuMuon.isEmpty() || maSach.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu để xóa", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Xóa", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            ChiTietPhieuMuonDAO dao = new ChiTietPhieuMuonDAO();
            ChiTietPhieuMuonModel ctpmm = dao.findbyId(maPhieuMuon, maSach);
            if (ctpmm != null) {
                dao.updateBookQuantity(ctpmm.getMasach(), ctpmm.getSoluongmuon(), false);
                dao.xoa(maPhieuMuon, maSach);
                ResetValue();
                GetData(model);
            }
        }
    }

    private void btnTimKiem_Click() {
        txtMaPhieuMuon.setEnabled(true);
        String maPhieuMuon = txtMaPhieuMuon.getText().trim();
        String maSach = txtMaSach.getText().trim();
        String soLuong = txtSoLuong.getText().trim();

        if (maPhieuMuon.isEmpty() && maSach.isEmpty() && soLuong.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập điều kiện tìm kiếm", "Thông báo",
                    JOptionPane.PLAIN_MESSAGE);
            return;
        }

        ChiTietPhieuMuonDAO dao = new ChiTietPhieuMuonDAO();
        List<ChiTietPhieuMuonDTO> list = dao.getAll();

        for (int i = model.getRowCount() - 1; i >= 0; i--)
            model.removeRow(i);

        for (ChiTietPhieuMuonDTO pm : list) {
            String pmTensach = pm.getTensach() != null ? pm.getTensach() : "";
            String pmSoLuong = String.valueOf(pm.getSoluongmuon());

            if ((maPhieuMuon.isEmpty() || pm.getMaphieumuon().toLowerCase().contains(maPhieuMuon.toLowerCase())) &&
                    (maSach.isEmpty() || pm.getMasach().toLowerCase().contains(maSach.toLowerCase())) &&
                    (soLuong.isEmpty() || pmSoLuong.equals(soLuong))) {
                Object[] row = {
                        pm.getMaphieumuon(),
                        pm.getMasach(),
                        pmTensach,
                        pm.getSoluongmuon()
                };
                model.addRow(row);
            }
        }

        JOptionPane.showMessageDialog(this, "Có " + model.getRowCount() + " dòng thỏa mãn điều kiện", "Thông báo",
                JOptionPane.PLAIN_MESSAGE);
    }

    private void btnSua_Click() {
        if (!utilities.PermissionUtil.isAllowedToModify(Nhanvien, this))
            return;
        String maPhieuMuon = txtMaPhieuMuon.getText().trim();
        System.out.println("MaPhieuMuon: " + maPhieuMuon);
        String maSach = txtMaSach.getText().trim();
        String soLuongStr = txtSoLuong.getText().trim();

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có dữ liệu", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        if (maPhieuMuon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu để sửa", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (maSach.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (soLuongStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập số lượng sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int soLuong;
        try {
            soLuong = Integer.parseInt(soLuongStr);
            if (soLuong <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ChiTietPhieuMuonDAO dao = new ChiTietPhieuMuonDAO();
        ChiTietPhieuMuonModel pm = dao.findbyId(maPhieuMuon, maSach);
        if (pm == null) {
            JOptionPane.showMessageDialog(this, "Mã sách ko tồn tại", "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!dao.checkBookAvailability(maSach, soLuong)) {
            JOptionPane.showMessageDialog(this, "Số lượng sách không đủ", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Revert old quantity
        dao.updateBookQuantity(pm.getMasach(), pm.getSoluongmuon(), false);
        System.out.println("khôi phục sô lượng xong ");
        // Check if the new quantity is valid
        // Update with new values
        pm.setSoluongmuon(soLuong);
        System.out.println("set sô lượng xong ");
        dao.sua(pm);
        System.out.println("sửa xong ");
        dao.updateBookQuantity(maSach, soLuong, true);
        ResetValue();
        GetData(model);
    }

    private void btnReset_Click() {
        GetData(model);
        ResetValue();
    }
}