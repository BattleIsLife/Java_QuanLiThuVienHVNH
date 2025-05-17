package view;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import dao.TheLoaiDAO;
import model.Nhanvien;
import model.Theloai;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

public class TheLoaiForm extends JPanel {

	private static final long serialVersionUID = 1L;
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
		FlatLightLaf.setup();
		setBounds(100, 100, 1029, 595);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã thể loại");
		lblNewLabel.setBounds(46, 14, 93, 23);
		lblNewLabel.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblNewLabel);
		
		txtMatheloai = new JTextField();
		txtMatheloai.setBounds(184, 10, 824, 31);
		txtMatheloai.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(txtMatheloai);
		txtMatheloai.setColumns(10);
		
		JLabel lblTnThLoi = new JLabel("Tên thể loại");
		lblTnThLoi.setBounds(41, 65, 98, 23);
		lblTnThLoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnThLoi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblTnThLoi);
		
		txtTentheloai = new JTextField();
		txtTentheloai.setBounds(184, 61, 824, 31);
		txtTentheloai.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtTentheloai.setColumns(10);
		this.add(txtTentheloai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 104, 962, 361);
		this.add(scrollPane);
		
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
		panel.setBounds(46, 489, 962, 33);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(20);
		this.add(panel);
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
