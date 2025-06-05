package view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatLightLaf;
import dao.PhieuMuonDAO;
import dao.NguoiMuonDAO;
import dao.NhanVienDAO;
import model.Nguoimuon;
import model.Nhanvien;
import model.PhieuMuonModel;
import model.PhieuMuonDTO;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PhieuMuonForm extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel model;
    private Nhanvien nhanvien;
    private JTextField txtMaPhieuMuon;
    private JTextField txtNgayMuon;
    private JTextField txtHanTraSach;
    private JTextField txtNguoiMuon;
    private JTextField txtNhanvien;
    private JButton btnThem;
    private JButton btnLuu;
    private JButton btnBoQua;
    private JButton btnSua;
    private JButton btnXoa;

    public PhieuMuonForm(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
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

        JLabel lblNgayMuon = new JLabel("Ngày mượn");
        lblNgayMuon.setBounds(22, 65, 120, 23);
        lblNgayMuon.setHorizontalAlignment(SwingConstants.LEFT);
        lblNgayMuon.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
        add(lblNgayMuon);

        txtNgayMuon = new JTextField();
        txtNgayMuon.setBounds(142, 61, 309, 31);
        txtNgayMuon.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
        txtNgayMuon.setColumns(10);
        add(txtNgayMuon);

        JLabel lblHanTraSach = new JLabel("Hạn trả sách");
        lblHanTraSach.setBounds(22, 116, 120, 23);
        lblHanTraSach.setHorizontalAlignment(SwingConstants.LEFT);
        lblHanTraSach.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
        add(lblHanTraSach);

        txtHanTraSach = new JTextField();
        txtHanTraSach.setBounds(142, 112, 309, 31);
        txtHanTraSach.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
        txtHanTraSach.setColumns(10);
        add(txtHanTraSach);

        JLabel lblNguoiMuon = new JLabel("Người mượn");
        lblNguoiMuon.setBounds(512, 14, 120, 23);
        lblNguoiMuon.setHorizontalAlignment(SwingConstants.LEFT);
        lblNguoiMuon.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
        add(lblNguoiMuon);

        txtNguoiMuon = new JTextField();
        txtNguoiMuon.setBounds(642, 10, 309, 31);
        txtNguoiMuon.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
        txtNguoiMuon.setColumns(10);
        add(txtNguoiMuon);

        JLabel lblNhanvien = new JLabel("Nhân viên");
        lblNhanvien.setBounds(512, 65, 120, 23);
        lblNhanvien.setHorizontalAlignment(SwingConstants.LEFT);
        lblNhanvien.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
        add(lblNhanvien);

        txtNhanvien = new JTextField();
        txtNhanvien.setBounds(642, 61, 309, 31);
        txtNhanvien.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
        txtNhanvien.setColumns(10);
        add(txtNhanvien);

        String[] col = { "Mã phiếu mượn", "Ngày mượn", "Hạn trả sách", "Người mượn", "Nhân viên" };
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
        txtNgayMuon.setText("");
        txtHanTraSach.setText("");
        txtNguoiMuon.setText("");
        txtNhanvien.setText("");
        btnThem.setEnabled(true);
        btnLuu.setEnabled(false);
        btnBoQua.setEnabled(false);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
    }

    private void GetData(DefaultTableModel model) {
        PhieuMuonDAO dao = new PhieuMuonDAO();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateOnlyFormat = new SimpleDateFormat("yyyy-MM-dd");

        int rowNum = model.getRowCount();
        for (int i = rowNum - 1; i >= 0; i--)
            model.removeRow(i);

        List<PhieuMuonDTO> list = dao.getAll();
        for (PhieuMuonDTO pm : list) {
            Object[] row = {
                    pm.getMaphieumuon(),
                    dateFormat.format(pm.getNgaymuon()),
                    dateOnlyFormat.format(pm.getHantrasach()),
                    pm.getTennguoimuon() != null ? pm.getTennguoimuon() : "Unknown",
                    pm.getTennhanvien() != null ? pm.getTennhanvien() : "Unknown"
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
            txtNgayMuon.setText(model.getValueAt(selectedRow, 1).toString());
            txtHanTraSach.setText(model.getValueAt(selectedRow, 2).toString());
            txtNguoiMuon.setText(model.getValueAt(selectedRow, 3).toString());
            txtNhanvien.setText(model.getValueAt(selectedRow, 4).toString());
            btnBoQua.setEnabled(true);
        }
    }

    private void btnThem_Click() {
        // if (!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
        //     return;
        ResetValue();
        txtMaPhieuMuon.setText("");
        txtMaPhieuMuon.setEnabled(true);
        txtNgayMuon.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        txtHanTraSach.setText("");
        txtNguoiMuon.setText("");
        txtNhanvien.setText(nhanvien.getTenNhanVien());

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
        String ngayMuonStr = txtNgayMuon.getText().trim();
        String hanTraSachStr = txtHanTraSach.getText().trim();
        String tenNguoiMuon = txtNguoiMuon.getText().trim();
        String tenNhanvien = txtNhanvien.getText().trim();

        if (maPhieuMuon.isEmpty() || maPhieuMuon.equals("AUTO")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập mã phiếu mượn", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (ngayMuonStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập ngày mượn", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (hanTraSachStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập hạn trả sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tenNguoiMuon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên người mượn", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tenNhanvien.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên nhân viên", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayMuon, hanTraSach;
        try {
            ngayMuon = dateTimeFormat.parse(ngayMuonStr);
            hanTraSach = dateFormat.parse(hanTraSachStr);
            if (hanTraSach.before(ngayMuon)) {
                JOptionPane.showMessageDialog(this, "Hạn trả sách phải sau ngày mượn", "Thông báo",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ (yyyy-MM-dd [HH:mm:ss])", "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        NguoiMuonDAO nguoiMuonDAO = new NguoiMuonDAO();
        NhanVienDAO nhanVienDAO = new NhanVienDAO();
        Nguoimuon nguoiMuon = nguoiMuonDAO.selectByTen(tenNguoiMuon);
        Nhanvien nhanvienFromDb = nhanVienDAO.selectByTen(tenNhanvien);

        if (nguoiMuon == null) {
            JOptionPane.showMessageDialog(this, "Người mượn không tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nhanvienFromDb == null) {
            JOptionPane.showMessageDialog(this, "Nhân viên không tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PhieuMuonDAO dao = new PhieuMuonDAO();
        PhieuMuonModel existing = dao.selectById(maPhieuMuon);
        if (existing != null) {
            JOptionPane.showMessageDialog(this, "Trùng mã phiếu mượn", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PhieuMuonModel pm = new PhieuMuonModel();
        pm.setMaphieumuon(maPhieuMuon);
        pm.setNgaymuon(ngayMuon);
        pm.setHantrasach(hanTraSach);
        pm.setManguoimuon(nguoiMuon.getMaNguoiMuon());
        pm.setManhanvien(nhanvienFromDb.getMaNhanVien());
        dao.them(pm);
        ResetValue();
        GetData(model);
    }

    private void btnXoa_Click() {
        if (!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
            return;
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có dữ liệu", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        String maPhieuMuon = txtMaPhieuMuon.getText().trim();
        if (maPhieuMuon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu để xóa", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Xóa", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            PhieuMuonDAO dao = new PhieuMuonDAO();
            dao.xoa(maPhieuMuon);
            ResetValue();
            GetData(model);
        }
    }

    private void btnTimKiem_Click() {
        String maPhieuMuon = txtMaPhieuMuon.getText().trim();
        String ngayMuon = txtNgayMuon.getText().trim();
        String hanTraSach = txtHanTraSach.getText().trim();
        String tenNguoiMuon = txtNguoiMuon.getText().trim();
        String tenNhanvien = txtNhanvien.getText().trim();

        if (maPhieuMuon.isEmpty() && ngayMuon.isEmpty() && hanTraSach.isEmpty() && tenNguoiMuon.isEmpty()
                && tenNhanvien.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ít nhất một điều kiện tìm kiếm", "Thông báo",
                    JOptionPane.PLAIN_MESSAGE);
            return;
        }

        PhieuMuonDAO dao = new PhieuMuonDAO();
        List<PhieuMuonDTO> list = dao.getAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateOnlyFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = model.getRowCount() - 1; i >= 0; i--)
            model.removeRow(i);

        for (PhieuMuonDTO pm : list) {
            String ngayMuonDb = dateFormat.format(pm.getNgaymuon());
            String hanTraSachDb = dateOnlyFormat.format(pm.getHantrasach());
            String tenNguoiMuonDb = pm.getTennguoimuon() != null ? pm.getTennguoimuon() : "";
            String tenNhanvienDb = pm.getTennhanvien() != null ? pm.getTennhanvien() : "";

            if ((maPhieuMuon.isEmpty() || pm.getMaphieumuon().toLowerCase().contains(maPhieuMuon.toLowerCase())) &&
                    (ngayMuon.isEmpty() || ngayMuonDb.toLowerCase().contains(ngayMuon.toLowerCase())) &&
                    (hanTraSach.isEmpty() || hanTraSachDb.toLowerCase().contains(hanTraSach.toLowerCase())) &&
                    (tenNguoiMuon.isEmpty() || tenNguoiMuonDb.toLowerCase().contains(tenNguoiMuon.toLowerCase())) &&
                    (tenNhanvien.isEmpty() || tenNhanvienDb.toLowerCase().contains(tenNhanvien.toLowerCase()))) {
                Object[] row = {
                        pm.getMaphieumuon(),
                        ngayMuonDb,
                        hanTraSachDb,
                        tenNguoiMuonDb,
                        tenNhanvienDb
                };
                model.addRow(row);
            }
        }

        JOptionPane.showMessageDialog(this, "Có " + model.getRowCount() + " dòng thỏa mãn điều kiện", "Thông báo",
                JOptionPane.PLAIN_MESSAGE);
    }

    private void btnSua_Click() {
        // if (!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
        //     return;
        String maPhieuMuon = txtMaPhieuMuon.getText().trim();
        String ngayMuonStr = txtNgayMuon.getText().trim();
        String hanTraSachStr = txtHanTraSach.getText().trim();
        String tenNguoiMuon = txtNguoiMuon.getText().trim();
        String tenNhanvien = txtNhanvien.getText().trim();

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có dữ liệu", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        if (maPhieuMuon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu để sửa", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (ngayMuonStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập ngày mượn", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (hanTraSachStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập hạn trả sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tenNguoiMuon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên người mượn", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tenNhanvien.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên nhân viên", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayMuon, hanTraSach;
        try {
            ngayMuon = dateTimeFormat.parse(ngayMuonStr);
            hanTraSach = dateFormat.parse(hanTraSachStr);
            if (hanTraSach.before(ngayMuon)) {
                JOptionPane.showMessageDialog(this, "Hạn trả sách phải sau ngày mượn", "Thông báo",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ (yyyy-MM-dd [HH:mm:ss])", "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        NguoiMuonDAO nguoiMuonDAO = new NguoiMuonDAO();
        NhanVienDAO nhanVienDAO = new NhanVienDAO();
        Nguoimuon nguoiMuon = nguoiMuonDAO.selectByTen(tenNguoiMuon);
        Nhanvien nhanvienFromDb = nhanVienDAO.selectByTen(tenNhanvien);

        if (nguoiMuon == null) {
            JOptionPane.showMessageDialog(this, "Người mượn không tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nhanvienFromDb == null) {
            JOptionPane.showMessageDialog(this, "Nhân viên không tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PhieuMuonDAO dao = new PhieuMuonDAO();
        PhieuMuonModel pm = dao.selectById(maPhieuMuon);
        if (pm == null) {
            JOptionPane.showMessageDialog(this, "Phiếu mượn không tồn tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        pm.setNgaymuon(ngayMuon);
        pm.setHantrasach(hanTraSach);
        pm.setManguoimuon(nguoiMuon.getMaNguoiMuon());
        pm.setManhanvien(nhanvienFromDb.getMaNhanVien());
        dao.sua(pm);
        ResetValue();
        GetData(model);
    }

    private void btnReset_Click() {
        GetData(model);
        ResetValue();
    }
}