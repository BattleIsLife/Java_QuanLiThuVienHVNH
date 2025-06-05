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
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class CaiDatForm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaNV;
	private JTextField txtDiaChi;
	private JTextField txtTenNV;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JTextField txtChucvu;
	private DefaultTableModel model;
	private JTextField spnNgaySinh;
	private JRadioButton rdoNam, rdoNu;
	private JComboBox<String> cboQuyenHan;
	private JButton btnLuu, btnBoQua;
	JCheckBox chkHienthi;

	/**
	 * Create the panel.
	 */
	private Nhanvien nv;
	private JButton btnDangxuat;
	private JPasswordField txtMatkhau;
	private MainApplication main_gui;
	
	public MainApplication getMainGUI()
	{
		return main_gui;
	}

	public Nhanvien getNv() {
		return nv;
	}

	public void setNv(Nhanvien nv) {
		this.nv = nv;
	}

	public CaiDatForm(Nhanvien nv, MainApplication main_gui) {
		
		
		this.nv = nv;
		this.main_gui = main_gui;
		
		FlatLightLaf.setup();
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên");
		lblNewLabel.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 12, 132, 42);
		add(lblNewLabel);
		
		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtMaNV.setBounds(198, 18, 231, 32);
		add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblaCh.setBounds(643, 12, 132, 42);
		add(lblaCh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(791, 18, 231, 32);
		add(txtDiaChi);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
		lblTnNhnVin.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblTnNhnVin.setBounds(50, 66, 132, 42);
		add(lblTnNhnVin);
		
		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(198, 72, 231, 32);
		add(txtTenNV);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(643, 66, 132, 42);
		add(lblNewLabel_1);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtEmail.setColumns(10);
		txtEmail.setBounds(791, 72, 231, 32);
		add(txtEmail);
		
		JLabel lblNgySinnh = new JLabel("Ngày sinh");
		lblNgySinnh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblNgySinnh.setBounds(50, 120, 132, 42);
		add(lblNgySinnh);
		
		spnNgaySinh = new JTextField();
		spnNgaySinh.setEditable(false);
		
		spnNgaySinh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		spnNgaySinh.setBounds(198, 125, 231, 32);
		
		spnNgaySinh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!( (c>='0' && c <= '9') || c == '-' || c == '\b') )
					e.consume();
			}
		});
		
		add(spnNgaySinh);
		
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
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblGiiTnh.setBounds(50, 174, 132, 42);
		add(lblGiiTnh);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(10);
		panel.setBounds(199, 177, 152, 32);
		add(panel);
		
		ButtonGroup grp = new ButtonGroup();
		
		rdoNam = new JRadioButton("Nam");
		rdoNam.setEnabled(false);
		rdoNam.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		grp.add(rdoNam);
		panel.add(rdoNam);
		
		rdoNu = new JRadioButton("Nữ");
		rdoNu.setEnabled(false);
		rdoNu.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		grp.add(rdoNu);
		panel.add(rdoNu);
		
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(20);
		flowLayout_1.setHgap(20);
		panel_1.setBounds(315, 358, 460, 77);
		add(panel_1);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel_1.add(btnLuu);
		
		btnBoQua = new JButton("Bỏ qua");
		btnBoQua.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel_1.add(btnBoQua);
		
		btnDangxuat = new JButton("Đăng xuất");
		btnDangxuat.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel_1.add(btnDangxuat);
		
		JLabel lblQuynHn = new JLabel("Quyền hạn");
		lblQuynHn.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblQuynHn.setBounds(643, 169, 132, 42);
		add(lblQuynHn);
		
		cboQuyenHan = new JComboBox<String>();
		cboQuyenHan.setEnabled(false);
		cboQuyenHan.setModel(new DefaultComboBoxModel<String>(new String[] {"Không có", "Nhân viên", "Admin"}));
		cboQuyenHan.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		cboQuyenHan.setBounds(791, 176, 231, 30);
		add(cboQuyenHan);
		
		JLabel lblChcV = new JLabel("Chức vụ");
		lblChcV.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblChcV.setBounds(50, 223, 132, 42);
		add(lblChcV);
		
		txtChucvu = new JTextField();
		txtChucvu.setEditable(false);
		txtChucvu.setText("");
		txtChucvu.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtChucvu.setColumns(10);
		txtChucvu.setBounds(198, 229, 231, 32);
		add(txtChucvu);
		
		JLabel lblChcV_1 = new JLabel("Mật khẩu");
		lblChcV_1.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		lblChcV_1.setBounds(643, 223, 132, 42);
		add(lblChcV_1);
		
		txtMatkhau = new JPasswordField();
		txtMatkhau.setFont(new Font("Adwaita Sans", Font.PLAIN, 17));
		txtMatkhau.setBounds(791, 230, 231, 30);
		add(txtMatkhau);
		
		chkHienthi = new JCheckBox("Hiển thị mật khẩu");
		chkHienthi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		chkHienthi.setBounds(640, 288, 236, 28);
		add(chkHienthi);
		
		SwingUtilities.updateComponentTreeUI(this);
		
		FormLoad();
	}
	
	private void FormLoad() {
		try {
			new controller.CaiDatController(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JTextField getTxtMaNV() {
		return txtMaNV;
	}

	public void setTxtMaNV(JTextField txtMaNV) {
		this.txtMaNV = txtMaNV;
	}

	public JTextField getTxtDiaChi() {
		return txtDiaChi;
	}

	public void setTxtDiaChi(JTextField txtDiaChi) {
		this.txtDiaChi = txtDiaChi;
	}

	public JTextField getTxtTenNV() {
		return txtTenNV;
	}

	public void setTxtTenNV(JTextField txtTenNV) {
		this.txtTenNV = txtTenNV;
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

	public JTextField getTxtChucvu() {
		return txtChucvu;
	}

	public void setTxtChucvu(JTextField txtChucvu) {
		this.txtChucvu = txtChucvu;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JTextField getSpnNgaySinh() {
		return spnNgaySinh;
	}

	public void setSpnNgaySinh(JTextField spnNgaySinh) {
		this.spnNgaySinh = spnNgaySinh;
	}

	public JRadioButton getRdoNam() {
		return rdoNam;
	}

	public void setRdoNam(JRadioButton rdoNam) {
		this.rdoNam = rdoNam;
	}

	public JRadioButton getRdoNu() {
		return rdoNu;
	}

	public void setRdoNu(JRadioButton rdoNu) {
		this.rdoNu = rdoNu;
	}

	public JComboBox<String> getCboQuyenHan() {
		return cboQuyenHan;
	}

	public void setCboQuyenHan(JComboBox<String> cboQuyenHan) {
		this.cboQuyenHan = cboQuyenHan;
	}

	public JButton getBtnLuu() {
		return btnLuu;
	}

	public JButton getBtnBoQua() {
		return btnBoQua;
	}

	public JPasswordField getTxtMatkhau() {
		return txtMatkhau;
	}

	public JButton getBtnDangxuat() {
		return btnDangxuat;
	}

	public JCheckBox getChkHienthi() {
		return chkHienthi;
	}
}
