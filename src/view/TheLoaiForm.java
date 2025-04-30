package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import dao.TheLoaiDAO;
import model.Nhanvien;
import model.Theloai;

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

public class TheLoaiForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMatheloai;
	private JTextField txtTentheloai;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the frame.
	 */
//	public static void main(String[] args)
//	{
//		Nhanvien nv = new Nhanvien();
//		nv.setQuyenHan(PermissionLevel.NHANVIEN);
//		new TheLoaiForm(nv);
//	}
	
	private Nhanvien nhanvien;
	
	public TheLoaiForm(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
		setTitle("Thể loại");
		FlatLightLaf.setup();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1002, 696);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Mã thể loại");
		lblNewLabel.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 20, 10, 20);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtMatheloai = new JTextField();
		txtMatheloai.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_txtMatheloai = new GridBagConstraints();
		gbc_txtMatheloai.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMatheloai.insets = new Insets(10, 20, 10, 20);
		gbc_txtMatheloai.gridx = 1;
		gbc_txtMatheloai.gridy = 0;
		contentPane.add(txtMatheloai, gbc_txtMatheloai);
		txtMatheloai.setColumns(10);
		
		JLabel lblTnThLoi = new JLabel("Tên thể loại");
		lblTnThLoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnThLoi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTnThLoi = new GridBagConstraints();
		gbc_lblTnThLoi.insets = new Insets(10, 20, 10, 20);
		gbc_lblTnThLoi.gridx = 0;
		gbc_lblTnThLoi.gridy = 1;
		contentPane.add(lblTnThLoi, gbc_lblTnThLoi);
		
		txtTentheloai = new JTextField();
		txtTentheloai.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtTentheloai.setColumns(10);
		GridBagConstraints gbc_txtTentheloai = new GridBagConstraints();
		gbc_txtTentheloai.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTentheloai.insets = new Insets(10, 20, 10, 20);
		gbc_txtTentheloai.gridx = 1;
		gbc_txtTentheloai.gridy = 1;
		contentPane.add(txtTentheloai, gbc_txtTentheloai);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(10, 20, 10, 20);
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		String[] col = {"Mã thể loại", "Tên thể loại"};
		model = new DefaultTableModel(null, col);
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
		gbc_panel.gridy = 3;
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
	
	private void FormLoad()
	{
		ResetValue();
		GetData(model);
	}
	
	private void ResetValue()
	{
		txtMatheloai.setEnabled(false);
		txtMatheloai.setText("");
		txtTentheloai.setText("");
		btnThem.setEnabled(true);
		btnLuu.setEnabled(false);
		btnBoQua.setEnabled(false);
		btnSua.setEnabled(true);
		btnXoa.setEnabled(true);
	}
	
	private void GetData(DefaultTableModel model)
	{
		TheLoaiDAO dao = new TheLoaiDAO();
		
		int rowNum = model.getRowCount();
		
		for(int i = rowNum - 1; i>=0; i--)
			model.removeRow(i);
		
		List<Theloai> list = dao.getAll();
		for(Theloai tl : list)
		{
			Object[] row = {tl.getMaTheLoai(), tl.getTenTheLoai()};
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
			txtMatheloai.setText(model.getValueAt(selectedRow, 0).toString());
			txtTentheloai.setText(model.getValueAt(selectedRow, 1).toString());
		}
		
		btnBoQua.setEnabled(true);
	}
	
	private void btnThem_Click()
	{
		if(!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
			return;
		ResetValue();
		txtMatheloai.setEnabled(true);
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
		
		if(txtMatheloai.getText().trim().equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập mã thể loại", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(txtTentheloai.getText().trim().equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập tên thể loại", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		TheLoaiDAO dao = new TheLoaiDAO();
		Theloai key = dao.selectById(txtMatheloai.getText().trim());
		if(key != null)
		{
			JOptionPane.showMessageDialog(this, "Trùng mã thể loại", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String matl = txtMatheloai.getText().trim();
		String tentl = txtTentheloai.getText().trim();
		
		dao.them(new Theloai(matl, tentl));
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

		if(txtMatheloai.getText().trim().equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu để xóa", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Xóa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
		{
			String matl = txtMatheloai.getText().trim();
			TheLoaiDAO dao = new TheLoaiDAO();
			dao.xoa(matl);
			ResetValue();
			GetData(model);
		}
	}
	
	private void btnTimKiem_Click()
	{
		String ma = txtMatheloai.getText();
		String ten = txtTentheloai.getText().trim();
		if(ma.length() == 0 && ten.length() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập điều kiện tìm kiếm", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		TheLoaiDAO dao = new TheLoaiDAO();
		List<Theloai> list = dao.getAll();
		
		for(int i = model.getRowCount()-1; i>=0; i--)
			model.removeRow(i);
		
		for(Theloai t : list)
		{
			if(t.getTenTheLoai().toLowerCase().contains(ten.toLowerCase()))
			{
				Object[] row = {t.getMaTheLoai(), t.getTenTheLoai()};
				model.addRow(row);
			}
		}
		
		JOptionPane.showMessageDialog(this, "Có " + model.getRowCount() + " dòng thỏa mãn điều kiện", "Thông báo", JOptionPane.PLAIN_MESSAGE);
		ResetValue();
	}
	
	private void btnSua_Click()
	{
		if(!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
			return;
		String ma = txtMatheloai.getText();
		String ten = txtTentheloai.getText().trim();
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
			JOptionPane.showMessageDialog(this, "Chưa nhập tên thể loại", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		TheLoaiDAO dao = new TheLoaiDAO();
		dao.sua(new Theloai(ma, ten));
		ResetValue();
		GetData(model);
	}
	
	private void btnReset_Click()
	{
		GetData(model);
		ResetValue();
	}
	
}
