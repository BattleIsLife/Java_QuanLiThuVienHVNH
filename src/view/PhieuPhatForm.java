package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import controller.PhieuPhatController;
import model.Nhanvien;
import utilities.PermissionUtil;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.FlowLayout;

public class PhieuPhatForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaPhieu;
	private JTextField txtNV;
	private JTextField txtThoiGian;
	private JTextArea txtGhiChu;
	private JButton btnThem, btnSua, btnXoa, btnLuu, btnBoQua, btnTimKiem, btnHienThi;
	
	private JSpinner spnTienPhat;
	
	private JComboBox<String> cboNguoiMuon;
	
	private JTable table;
	private DefaultTableModel model;

	private Nhanvien nhanvien;
	public JTextField getTxtMaPhieu() {
		return txtMaPhieu;
	}
	public JTextField getTxtNV() {
		return txtNV;
	}
	public JTextField getTxtThoiGian() {
		return txtThoiGian;
	}
	public JTextArea getTxtGhiChu() {
		return txtGhiChu;
	}
	public JButton getBtnThem() {
		return btnThem;
	}
	public JButton getBtnSua() {
		return btnSua;
	}
	public JButton getBtnXoa() {
		return btnXoa;
	}
	public JButton getBtnLuu() {
		return btnLuu;
	}
	public JButton getBtnBoQua() {
		return btnBoQua;
	}
	public JButton getBtnTimKiem() {
		return btnTimKiem;
	}
	public JButton getBtnHienThi() {
		return btnHienThi;
	}
	public JSpinner getSpnTienPhat() {
		return spnTienPhat;
	}
	public JComboBox<String> getCboNguoiMuon() {
		return cboNguoiMuon;
	}
	public JTable getTable() {
		return table;
	}
	public DefaultTableModel getModel() {
		return model;
	}
	public Nhanvien getNhanvien() {
		return nhanvien;
	}

	private JScrollPane scrollPane_1;
	/**
	 * Create the panel.
	 */
	public PhieuPhatForm(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
		FlatLightLaf.setup();
		setLayout(null);
		JLabel lblMPhiuPht = new JLabel("Mã phiếu phạt");
		lblMPhiuPht.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblMPhiuPht.setBounds(22, 18, 146, 22);
		add(lblMPhiuPht);
		
		txtMaPhieu = new JTextField();
		txtMaPhieu.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtMaPhieu.setEditable(false);
		txtMaPhieu.setBounds(174, 13, 242, 30);
		add(txtMaPhieu);
		txtMaPhieu.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tiền phạt");
		lblNewLabel_1.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(503, 13, 101, 22);
		add(lblNewLabel_1);
		
		spnTienPhat = new JSpinner();
		spnTienPhat.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		spnTienPhat.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), Float.valueOf(10000000), Float.valueOf(1)));
		spnTienPhat.setBounds(616, 8, 197, 30);
		add(spnTienPhat);
		
		JLabel lblNewLabel = new JLabel("Người mượn");
		lblNewLabel.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 68, 116, 22);
		add(lblNewLabel);
		
		cboNguoiMuon = new JComboBox<String>();
		cboNguoiMuon.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		cboNguoiMuon.setBounds(174, 63, 242, 30);
		add(cboNguoiMuon);
		
		JLabel lblGhiCh = new JLabel("Ghi chú");
		lblGhiCh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblGhiCh.setBounds(513, 61, 80, 22);
		add(lblGhiCh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(618, 66, 350, 131);
		add(scrollPane);
		
		txtGhiChu = new JTextArea();
		txtGhiChu.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtGhiChu.setLineWrap(true);
		scrollPane.setViewportView(txtGhiChu);
		
		JLabel lblNhnVin = new JLabel("Nhân viên");
		lblNhnVin.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblNhnVin.setBounds(39, 118, 109, 22);
		add(lblNhnVin);
		
		txtNV = new JTextField();
		txtNV.setEditable(false);
		txtNV.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtNV.setBounds(174, 113, 242, 30);
		add(txtNV);
		txtNV.setColumns(10);
		
		JLabel lblThiGianPht = new JLabel("Thời gian phạt");
		lblThiGianPht.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblThiGianPht.setBounds(22, 168, 136, 22);
		add(lblThiGianPht);
		
		txtThoiGian = new JTextField();
		txtThoiGian.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtThoiGian.setBounds(174, 163, 242, 30);
		add(txtThoiGian);
		txtThoiGian.setColumns(10);
		
		String[] column = {"Mã phiếu phạt", "Người mượn", "Nhân viên", "Thời gian phạt", "Tiền phạt"};
		model = new DefaultTableModel(null, column);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(7);
		panel.setBounds(803, 222, 164, 275);
		add(panel);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel.add(btnXoa);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel.add(btnLuu);
		
		btnBoQua = new JButton("Bỏ qua");
		btnBoQua.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel.add(btnBoQua);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel.add(btnTimKiem);
		
		btnHienThi = new JButton("Hiển thị");
		btnHienThi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel.add(btnHienThi);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(17, 221, 751, 275);
		add(scrollPane_1);
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		
		table.setDefaultEditor(Object.class, null);
		table.setModel(model);
		
		new PhieuPhatController(this);
		SwingUtilities.updateComponentTreeUI(this);
	}
}
