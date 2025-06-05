package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import controller.CaLamController;
import model.Nhanvien;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;

public class CaLamForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaCa;
	private JTextField txtHoTen;
	private JTextField txtNgayLam;
	private JTable table;
	private DefaultTableModel model;
	private JComboBox<String> cboNV;

	private JButton btnThem, btnSua, btnXoa, btnBoQua, btnLuu, btnTimKiem, btnHienThi;

	private Nhanvien nhanvien;

	public CaLamForm(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
		FlatLightLaf.setup();
		setLayout(null);
		
		JLabel lblMCaLm = new JLabel("Mã ca làm");
		lblMCaLm.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblMCaLm.setBounds(30, 20, 146, 38);
		add(lblMCaLm);
		
		txtMaCa = new JTextField();
		txtMaCa.setEditable(false);
		txtMaCa.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtMaCa.setBounds(194, 22, 211, 34);
		add(txtMaCa);
		txtMaCa.setColumns(10);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên");
		lblMNhnVin.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblMNhnVin.setBounds(30, 81, 146, 38);
		add(lblMNhnVin);
		
		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		txtHoTen.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(194, 143, 211, 34);
		add(txtHoTen);
		
		JLabel lblHTn = new JLabel("Họ tên");
		lblHTn.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblHTn.setBounds(30, 141, 146, 38);
		add(lblHTn);
		
		cboNV = new JComboBox<String>();
		cboNV.setEditable(true);
		cboNV.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		cboNV.setBounds(194, 83, 211, 35);
		add(cboNV);
		
		JLabel lblThiGian = new JLabel("Ngày làm");
		lblThiGian.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblThiGian.setBounds(570, 20, 146, 38);
		add(lblThiGian);
		
		txtNgayLam = new JTextField();
		txtNgayLam.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtNgayLam.setColumns(10);
		txtNgayLam.setBounds(734, 22, 211, 34);
		add(txtNgayLam);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		btnTimKiem.setBounds(734, 85, 146, 31);
		add(btnTimKiem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 206, 686, 262);
		add(scrollPane);
		
		String[] col = {"Mã ca làm", "Mã nhân viên", "Họ tên", "Ngày làm"};
		model = new DefaultTableModel(null, col);
		
		table = new JTable();
		table.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		scrollPane.setViewportView(table);
		table.setDefaultEditor(Object.class, null);
		table.setModel(model);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(20);
		panel.setBounds(734, 206, 146, 262);
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
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel.add(btnLuu);
		
		btnBoQua = new JButton("Bỏ qua");
		btnBoQua.setEnabled(false);
		btnBoQua.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel.add(btnBoQua);
		
		btnHienThi = new JButton("Hiển thị");
		btnHienThi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		btnHienThi.setBounds(734, 140, 146, 31);
		add(btnHienThi);

		SwingUtilities.updateComponentTreeUI(this);

		new CaLamController(this);
	}

	public JTextField getTxtMaCa() {
		return txtMaCa;
	}

	public JTextField getTxtHoTen() {
		return txtHoTen;
	}

	public JTextField getTxtNgayLam() {
		return txtNgayLam;
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public JComboBox<String> getCboNV() {
		return cboNV;
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

	public JButton getBtnBoQua() {
		return btnBoQua;
	}

	public JButton getBtnLuu() {
		return btnLuu;
	}

	public JButton getBtnTimKiem() {
		return btnTimKiem;
	}

	public JButton getBtnHienThi() {
		return btnHienThi;
	}

	public Nhanvien getNhanvien() {
		return nhanvien;
	}
}