package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import dao.NhaXuatBanDAO;
import model.Nhanvien;
import model.Nhaxuatban;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NhaXuatBanForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the frame.
	 */
//	public static void main(String[] args)
//	{
//		Nhanvien nv = new Nhanvien();
//		nv.setQuyenHan(PermissionLevel.NHANVIEN);
//		new NhaXuatBanForm(nv);
//	}
	private Nhanvien nhanvien;
	
	public NhaXuatBanForm(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
		txtEmail.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtEmail.setForeground(new Color(0, 0, 0));
		txtEmail.setColumns(10);
		setTitle("Nhà xuất bản");
		FlatLightLaf.setup();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 1002, 696);
		this.setSize(1002, 696);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Mã NXB");
		lblNewLabel.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 20, 10, 20);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtMaNXB = new JTextField();
		txtMaNXB.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_txtMaNXB = new GridBagConstraints();
		gbc_txtMaNXB.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMaNXB.insets = new Insets(10, 20, 10, 20);
		gbc_txtMaNXB.gridx = 1;
		gbc_txtMaNXB.gridy = 0;
		contentPane.add(txtMaNXB, gbc_txtMaNXB);
		txtMaNXB.setColumns(10);
		
		JLabel lblTnThLoi = new JLabel("Tên NXB");
		lblTnThLoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnThLoi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTnThLoi = new GridBagConstraints();
		gbc_lblTnThLoi.insets = new Insets(10, 20, 10, 20);
		gbc_lblTnThLoi.gridx = 0;
		gbc_lblTnThLoi.gridy = 1;
		contentPane.add(lblTnThLoi, gbc_lblTnThLoi);
		
		txtTenNXB = new JTextField();
		txtTenNXB.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtTenNXB.setColumns(10);
		GridBagConstraints gbc_txtTenNXB = new GridBagConstraints();
		gbc_txtTenNXB.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenNXB.insets = new Insets(10, 20, 10, 20);
		gbc_txtTenNXB.gridx = 1;
		gbc_txtTenNXB.gridy = 1;
		contentPane.add(txtTenNXB, gbc_txtTenNXB);
		
		String[] col = {"Mã NXB", "Tên NXB", "Địa chỉ", "SĐT", "Email"};
		model = new DefaultTableModel(null, col);
		
		GridBagConstraints gbc_lblDiachi = new GridBagConstraints();
		gbc_lblDiachi.insets = new Insets(10, 20, 10, 20);
		gbc_lblDiachi.gridx = 0;
		gbc_lblDiachi.gridy = 2;
		lblDiachi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiachi.setForeground(Color.BLACK);
		lblDiachi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		contentPane.add(lblDiachi, gbc_lblDiachi);
		
		GridBagConstraints gbc_txtDiachi = new GridBagConstraints();
		gbc_txtDiachi.insets = new Insets(10, 20, 10, 20);
		gbc_txtDiachi.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiachi.gridx = 1;
		gbc_txtDiachi.gridy = 2;
		txtDiachi.setToolTipText("");
		txtDiachi.setForeground(new Color(0, 0, 0));
		txtDiachi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		
		contentPane.add(txtDiachi, gbc_txtDiachi);
		
		GridBagConstraints gbc_lblNgySinh = new GridBagConstraints();
		gbc_lblNgySinh.insets = new Insets(10, 20, 10, 20);
		gbc_lblNgySinh.gridx = 0;
		gbc_lblNgySinh.gridy = 3;
		lblNgySinh.setForeground(new Color(0, 0, 0));
		lblNgySinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgySinh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		contentPane.add(lblNgySinh, gbc_lblNgySinh);
		txtSDT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!( (c>='0' && c <= '9') || c == '\b') )
					e.consume();
			}
		});
		txtSDT.setToolTipText("");
		txtSDT.setForeground(new Color(0, 0, 0));
		txtSDT.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		
		GridBagConstraints gbc_txtSDT = new GridBagConstraints();
		gbc_txtSDT.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSDT.insets = new Insets(10, 20, 10, 20);
		gbc_txtSDT.gridx = 1;
		gbc_txtSDT.gridy = 3;
		contentPane.add(txtSDT, gbc_txtSDT);
		
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(10, 20, 10, 20);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		contentPane.add(lblEmail, gbc_lblEmail);
		
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(10, 20, 10, 20);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 4;
		contentPane.add(txtEmail, gbc_txtEmail);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(10, 20, 10, 20);
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 5;
		contentPane.add(scrollPane, gbc_scrollPane);
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
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(20);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(10, 20, 10, 20);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		contentPane.add(panel, gbc_panel);
		btnThem.setBackground(new Color(255, 255, 255));
		
		
		btnThem.setFont(new Font("Adwaita Sans", Font.PLAIN, 20));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem_Click();
			}
		});
		panel.add(btnThem);
		btnSua.setBackground(new Color(255, 255, 255));
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSua_Click();
			}
		});
		btnSua.setFont(new Font("Adwaita Sans", Font.PLAIN, 20));
		panel.add(btnSua);
		
		btnXoa.setBackground(new Color(255, 255, 255));
		btnXoa.setFont(new Font("Adwaita Sans", Font.PLAIN, 20));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoa_Click();
			}
		});
		panel.add(btnXoa);
		btnLuu.setBackground(new Color(255, 255, 255));
		
		
		btnLuu.setFont(new Font("Adwaita Sans", Font.PLAIN, 20));
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLuu_Click();
			}
		});
		panel.add(btnLuu);
		btnBoQua.setBackground(new Color(255, 255, 255));
		
		
		btnBoQua.setFont(new Font("Adwaita Sans", Font.PLAIN, 20));
		btnBoQua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBoQua_Click();
			}
		});
		panel.add(btnBoQua);
		btnTimKiem.setToolTipText("Tìm kiếm theo tên, sđt, địa chỉ, email");
		
		btnTimKiem.setBackground(new Color(255, 255, 255));
		btnTimKiem.setFont(new Font("Adwaita Sans", Font.PLAIN, 20));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTimKiem_Click();
			}
		});
		panel.add(btnTimKiem);
		
		btnReset.setFont(new Font("Adwaita Sans", Font.PLAIN, 20));
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReset_Click();
			}
		});
		
		panel.add(btnReset);
		
		FormLoad();
		SwingUtilities.updateComponentTreeUI(this);
		this.setVisible(true);
	}
	
	private JButton btnThem = new JButton("Thêm");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnXoa = new JButton("Xóa");
	private JButton btnLuu = new JButton("Lưu");
	private JButton btnBoQua = new JButton("Bỏ qua");
	private JButton btnTimKiem = new JButton("Tìm kiếm");
	private final JButton btnReset = new JButton("Tải lại dữ liệu");
	private final JLabel lblNgySinh = new JLabel("SĐT");
	private final JLabel lblDiachi = new JLabel("Địa chỉ");
	private final JLabel lblEmail = new JLabel("Email");
	private final JTextField txtEmail = new JTextField();
	private JTextField txtMaNXB;
	private JTextField txtTenNXB;
	private final JTextField txtSDT = new JTextField();
	private final JTextField txtDiachi = new JTextField();
	
	
	private void FormLoad()
	{
		ResetValue();
		GetData(model);
	}
	
	private void ResetValue()
	{
		txtMaNXB.setEnabled(false);
		txtMaNXB.setText("");
		txtTenNXB.setText("");
		txtSDT.setText("");
		txtDiachi.setText("");
		txtEmail.setText("");
		btnThem.setEnabled(true);
		btnLuu.setEnabled(false);
		btnBoQua.setEnabled(false);
		btnSua.setEnabled(true);
		btnXoa.setEnabled(true);
	}
	
	private void GetData(DefaultTableModel model)
	{
		NhaXuatBanDAO dao = new NhaXuatBanDAO();
		
		int rowNum = model.getRowCount();
		
		for(int i = rowNum - 1; i>=0; i--)
			model.removeRow(i);
		
		List<Nhaxuatban> list = dao.getAll();
		for(Nhaxuatban nxb : list)
		{
			Object[] row = {nxb.getMaNXB(), nxb.getTenNXB(), nxb.getDiaChi(), nxb.getSDT(), nxb.getEmail()};
			model.addRow(row);
		}
		
	}
	
	private void table_Click()
	{
		if(!btnThem.isEnabled())
		{
			JOptionPane.showMessageDialog(this, "Bạn đang ở chế độ thêm mới", "Thông báo", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		if(model.getRowCount() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa có dữ liệu", "Thông báo", JOptionPane.PLAIN_MESSAGE);
			return;
		}

		int selectedRow = table.getSelectedRow();
		if(selectedRow>=0)
		{
			txtMaNXB.setText(model.getValueAt(selectedRow, 0).toString());
			txtTenNXB.setText(model.getValueAt(selectedRow, 1).toString());
			txtDiachi.setText(model.getValueAt(selectedRow, 2).toString());
			txtSDT.setText(model.getValueAt(selectedRow, 3).toString());
			txtEmail.setText(model.getValueAt(selectedRow, 4).toString());
		}
		
		btnBoQua.setEnabled(true);
	}
	
	private void btnThem_Click()
	{
		if(!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
			return;
		ResetValue();
		txtMaNXB.setEnabled(true);
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
		String ma = txtMaNXB.getText().trim();
		String ten = txtTenNXB.getText().trim();
		String diachi = txtDiachi.getText().trim();
		String sdt = txtSDT.getText().trim();
		String email = txtEmail.getText().trim();
		
		if(ma.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập mã NXB", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(ten.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập tên NXB", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(diachi.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập địa chỉ", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(sdt.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập SĐT", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(sdt.length() > 11)
		{
			JOptionPane.showMessageDialog(this, "SĐT quá dài (Độ dài tối đa là 11 số)", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(email.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập email", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		NhaXuatBanDAO dao = new NhaXuatBanDAO();
		Nhaxuatban key = dao.selectById(ma);
		if(key != null)
		{
			JOptionPane.showMessageDialog(this, "Trùng mã NXB", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		dao.them(new Nhaxuatban(ma, ten, diachi, sdt, email));
		ResetValue();
		GetData(model);
	}
	
	private void btnXoa_Click()
	{
		if(!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
			return;
		if(model.getRowCount() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa có dữ liệu", "Thông báo", JOptionPane.PLAIN_MESSAGE);
			return;
		}

		if(txtMaNXB.getText().trim().equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu để xóa", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Xóa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
		{
			String manxb = txtMaNXB.getText().trim();
			NhaXuatBanDAO dao = new NhaXuatBanDAO();
			dao.xoa(manxb);
			ResetValue();
			GetData(model);
		}
	}
	
	private void btnTimKiem_Click()
	{
		String ma = txtMaNXB.getText().trim();
		String ten = txtTenNXB.getText().trim();
		String diachi = txtDiachi.getText().trim();
		String sdt = txtSDT.getText().trim();
		String email = txtEmail.getText().trim();
		if(ma.length() == 0 && ten.length() == 0 && sdt.length() == 0 && diachi.length() == 0 && email.length() == 0)
		{
			JOptionPane.showMessageDialog(this, "Vui lòng nhập điều kiện tìm kiếm", "Thông báo", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		NhaXuatBanDAO dao = new NhaXuatBanDAO();
		List<Nhaxuatban> list = dao.getAll();
		
		for(int i = model.getRowCount()-1; i>=0; i--)
			model.removeRow(i);
		
		for(Nhaxuatban nxb : list)
		{
			if(nxb.getTenNXB().toLowerCase().contains(ten.toLowerCase()) && nxb.getDiaChi().toLowerCase().contains(diachi.toLowerCase()) && 
					nxb.getSDT().toLowerCase().contains(sdt.toLowerCase()) && nxb.getEmail().toLowerCase().contains(email.toLowerCase()))
			{
				Object[] row = {nxb.getMaNXB(), nxb.getTenNXB(), nxb.getDiaChi(), nxb.getSDT(), nxb.getEmail()};
				model.addRow(row);
			}
		}
		
		JOptionPane.showMessageDialog(this, "Có " + model.getRowCount() + " dòng thỏa mãn điều kiện", "Thông báo", JOptionPane.PLAIN_MESSAGE);	
	}
	
	private void btnSua_Click()
	{
		if(!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
			return;
		String ma = txtMaNXB.getText();
		String ten = txtTenNXB.getText().trim();
		String diachi = txtDiachi.getText().trim();
		String sdt = txtSDT.getText().trim();
		String email = txtEmail.getText().trim();
		
		if(model.getRowCount() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa có dữ liệu", "Thông báo", JOptionPane.PLAIN_MESSAGE);
			return;
		}

		if(ma.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu để sửa", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(ten.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập tên NXB", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(diachi.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập địa chỉ", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(sdt.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập SĐT", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(sdt.length() > 11)
		{
			JOptionPane.showMessageDialog(this, "SĐT quá dài (Độ dài tối đa là 11 số)", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(email.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập email", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		NhaXuatBanDAO dao = new NhaXuatBanDAO();
		dao.sua(new Nhaxuatban(ma, ten, diachi, sdt, email));
		ResetValue();
		GetData(model);
	}
	
	private void btnReset_Click()
	{
		GetData(model);
		ResetValue();
	}
	
}
