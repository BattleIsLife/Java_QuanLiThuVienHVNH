package view;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


import com.formdev.flatlaf.FlatLightLaf;

import dao.NhanVienDAO;
import model.Nhanvien;
//import model.PermissionLevel;
import model.PermissionLevel;
import utilities.PermissionUtil;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NguoiMuonForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaNguoiMuon;
	private JTextField txtDiaChi;
	private JTextField txtTenNguoiMuon;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JTable table;
	private DefaultTableModel model;
	private JRadioButton rdoNam, rdoNu;
	private JButton btnThem, btnSua, btnXoa, btnLuu, btnBoQua, btnTimKiem, btnHienThi;

	/**
	 * Create the panel.
	 */
	private Nhanvien nv;
	
	public Nhanvien getNv() {
		return nv;
	}

	public void setNv(Nhanvien nv) {
		this.nv = nv;
	}

	public NguoiMuonForm(Nhanvien nv) {
		
		this.nv = nv;
		if(!utilities.PermissionUtil.isAllowedToViewAsNhanvien(nv, this))
		{
			return;
		}
		
		FlatLightLaf.setup();
		
		SwingUtilities.updateComponentTreeUI(this);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã người mượn");
		lblNewLabel.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 12, 132, 42);
		add(lblNewLabel);
		
		txtMaNguoiMuon = new JTextField();
		txtMaNguoiMuon.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtMaNguoiMuon.setBounds(198, 18, 231, 32);
		add(txtMaNguoiMuon);
		txtMaNguoiMuon.setColumns(10);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblaCh.setBounds(643, 12, 132, 42);
		add(lblaCh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(791, 18, 231, 32);
		add(txtDiaChi);
		
		JLabel lblTnNhnVin = new JLabel("Tên người mượn");
		lblTnNhnVin.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblTnNhnVin.setBounds(50, 66, 152, 42);
		add(lblTnNhnVin);
		
		txtTenNguoiMuon = new JTextField();
		txtTenNguoiMuon.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtTenNguoiMuon.setColumns(10);
		txtTenNguoiMuon.setBounds(198, 72, 231, 32);
		add(txtTenNguoiMuon);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(643, 66, 132, 42);
		add(lblNewLabel_1);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtEmail.setColumns(10);
		txtEmail.setBounds(791, 72, 231, 32);
		add(txtEmail);
		
		JLabel lblSt = new JLabel("SĐT");
		lblSt.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblSt.setBounds(643, 120, 132, 42);
		add(lblSt);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtSDT.setColumns(10);
		txtSDT.setBounds(791, 126, 231, 32);
		
		txtSDT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!( (c>='0' && c <= '9') || c == '\b') )
					e.consume();
			}
		});
		
		add(txtSDT);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 174, 713, 347);
		add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		String[] columnNames = {"Mã người mượn", "Họ tên", "Giới tính", "SĐT", "Địa chỉ", "Email"};
		model = new DefaultTableModel(null, columnNames);
		table.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		table.setDefaultEditor(Object.class, null);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblGiiTnh.setBounds(50, 120, 132, 42);
		add(lblGiiTnh);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(10);
		panel.setBounds(198, 125, 152, 32);
		add(panel);
		
		ButtonGroup grp = new ButtonGroup();
		
		rdoNam = new JRadioButton("Nam");
		rdoNam.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		grp.add(rdoNam);
		panel.add(rdoNam);
		
		rdoNu = new JRadioButton("Nữ");
		rdoNu.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		grp.add(rdoNu);
		panel.add(rdoNu);
		
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(20);
		flowLayout_1.setHgap(20);
		panel_1.setBounds(791, 197, 247, 280);
		add(panel_1);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel_1.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel_1.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel_1.add(btnXoa);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel_1.add(btnLuu);
		
		btnBoQua = new JButton("Bỏ qua");
		btnBoQua.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel_1.add(btnBoQua);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel_1.add(btnTimKiem);
		
		btnHienThi = new JButton("Hiển thị");
		btnHienThi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel_1.add(btnHienThi);
		
		FormLoad();
	}
	
	private void FormLoad() {
		try {
			new controller.NguoiMuonController(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JTextField getTxtMaNguoiMuon() {
		return txtMaNguoiMuon;
	}

	public void setTxtMaNguoiMuon(JTextField txtMaNV) {
		this.txtMaNguoiMuon = txtMaNV;
	}

	public JTextField getTxtDiaChi() {
		return txtDiaChi;
	}

	public void setTxtDiaChi(JTextField txtDiaChi) {
		this.txtDiaChi = txtDiaChi;
	}

	public JTextField getTxtTenNguoiMuon() {
		return txtTenNguoiMuon;
	}

	public void setTxtTenNguoiMuon(JTextField txtTenNV) {
		this.txtTenNguoiMuon = txtTenNV;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtSDT() {
		return txtSDT;
	}

	public void setTxtSDT(JTextField txtSDT) {
		this.txtSDT = txtSDT;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JRadioButton getRdoNam() {
		return rdoNam;
	}

	public JRadioButton getRdoNu() {
		return rdoNu;
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

}
