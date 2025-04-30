package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import dao.TacGiaDAO;
import model.Nhanvien;
import model.Tacgia;
import utilities.DateTimeUtil;

import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.util.List;

import java.sql.Date;

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
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TacGiaForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMatacgia;
	private JTextField txtTentacgia;
	
	private final JTextField txtNgaysinh = new JTextField();
	private final JTextField txtDiachi = new JTextField();
	private final JRadioButton rdoNam = new JRadioButton("Nam");
	
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the frame.
	 */
//	public static void main(String[] args)
//	{
//		Nhanvien nv = new Nhanvien();
//		nv.setQuyenHan(PermissionLevel.NHANVIEN);
//		new TacGiaForm(nv);
//	}
	
	private Nhanvien nhanvien;
	
	public TacGiaForm(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
		setTitle("Tác giả");
		FlatLightLaf.setup();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1002, 696);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Mã tác giả");
		lblNewLabel.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 20, 10, 20);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtMatacgia = new JTextField();
		txtMatacgia.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_txtMatacgia = new GridBagConstraints();
		gbc_txtMatacgia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMatacgia.insets = new Insets(10, 20, 10, 20);
		gbc_txtMatacgia.gridx = 1;
		gbc_txtMatacgia.gridy = 0;
		contentPane.add(txtMatacgia, gbc_txtMatacgia);
		txtMatacgia.setColumns(10);
		
		JLabel lblTnThLoi = new JLabel("Tên tác giả");
		lblTnThLoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnThLoi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTnThLoi = new GridBagConstraints();
		gbc_lblTnThLoi.insets = new Insets(10, 20, 10, 20);
		gbc_lblTnThLoi.gridx = 0;
		gbc_lblTnThLoi.gridy = 1;
		contentPane.add(lblTnThLoi, gbc_lblTnThLoi);
		
		txtTentacgia = new JTextField();
		txtTentacgia.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtTentacgia.setColumns(10);
		GridBagConstraints gbc_txtTentacgia = new GridBagConstraints();
		gbc_txtTentacgia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTentacgia.insets = new Insets(10, 20, 10, 20);
		gbc_txtTentacgia.gridx = 1;
		gbc_txtTentacgia.gridy = 1;
		contentPane.add(txtTentacgia, gbc_txtTentacgia);
		
		String[] col = {"Mã tác giả", "Tên tác giả", "Ngày sinh", "Giới tính", "Địa chỉ"};
		model = new DefaultTableModel(null, col);
		
		GridBagConstraints gbc_lblNgySinh = new GridBagConstraints();
		gbc_lblNgySinh.anchor = GridBagConstraints.EAST;
		gbc_lblNgySinh.insets = new Insets(10, 20, 10, 20);
		gbc_lblNgySinh.gridx = 0;
		gbc_lblNgySinh.gridy = 2;
		lblNgySinh.setForeground(new Color(0, 0, 0));
		lblNgySinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgySinh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtNgaysinh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!( (c>='0' && c <= '9') || c == '-' || c == '\b') )
					e.consume();
			}
		});
		txtNgaysinh.setToolTipText("Định dạng: yyyy-DD-mm");
		txtNgaysinh.setForeground(new Color(0, 0, 0));
		txtNgaysinh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		contentPane.add(lblNgySinh, gbc_lblNgySinh);
		
		GridBagConstraints gbc_txtNgaysinh = new GridBagConstraints();
		gbc_txtNgaysinh.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNgaysinh.insets = new Insets(10, 20, 10, 20);
		gbc_txtNgaysinh.gridx = 1;
		gbc_txtNgaysinh.gridy = 2;
		contentPane.add(txtNgaysinh, gbc_txtNgaysinh);
		
		GridBagConstraints gbc_lblGioitinh = new GridBagConstraints();
		gbc_lblGioitinh.insets = new Insets(10, 20, 10, 20);
		gbc_lblGioitinh.gridx = 0;
		gbc_lblGioitinh.gridy = 3;
		lblGioitinh.setForeground(new Color(0, 0, 0));
		lblGioitinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblGioitinh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		contentPane.add(lblGioitinh, gbc_lblGioitinh);
		
		GridBagConstraints gbc_rdoNam = new GridBagConstraints();
		gbc_rdoNam.anchor = GridBagConstraints.WEST;
		gbc_rdoNam.insets = new Insets(10, 20, 10, 20);
		gbc_rdoNam.gridx = 1;
		gbc_rdoNam.gridy = 3;
		rdoNam.setForeground(new Color(0, 0, 0));
		rdoNam.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		contentPane.add(rdoNam, gbc_rdoNam);
		
		GridBagConstraints gbc_lblDiachi = new GridBagConstraints();
		gbc_lblDiachi.insets = new Insets(10, 20, 10, 20);
		gbc_lblDiachi.gridx = 0;
		gbc_lblDiachi.gridy = 4;
		lblDiachi.setForeground(new Color(0, 0, 0));
		lblDiachi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiachi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		contentPane.add(lblDiachi, gbc_lblDiachi);
		
		GridBagConstraints gbc_txtDiachi = new GridBagConstraints();
		gbc_txtDiachi.insets = new Insets(10, 20, 10, 20);
		gbc_txtDiachi.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiachi.gridx = 1;
		gbc_txtDiachi.gridy = 4;
		txtDiachi.setToolTipText("");
		txtDiachi.setForeground(new Color(0, 0, 0));
		txtDiachi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		
		contentPane.add(txtDiachi, gbc_txtDiachi);
		
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
		btnTimKiem.setToolTipText("Tìm kiếm theo tên, địa chỉ");
		
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
	private final JLabel lblNgySinh = new JLabel("Ngày sinh");
	private final JLabel lblGioitinh = new JLabel("Giới tính");
	private final JLabel lblDiachi = new JLabel("Địa chỉ");
	
	
	private void FormLoad()
	{
		ResetValue();
		GetData(model);
	}
	
	private void ResetValue()
	{
		txtMatacgia.setEnabled(false);
		txtMatacgia.setText("");
		txtTentacgia.setText("");
		txtNgaysinh.setText("");
		rdoNam.setSelected(false);
		txtDiachi.setText("");
		btnThem.setEnabled(true);
		btnLuu.setEnabled(false);
		btnBoQua.setEnabled(false);
		btnSua.setEnabled(true);
		btnXoa.setEnabled(true);
	}
	
	private void GetData(DefaultTableModel model)
	{
		TacGiaDAO dao = new TacGiaDAO();
		
		int rowNum = model.getRowCount();
		
		for(int i = rowNum - 1; i>=0; i--)
			model.removeRow(i);
		
		List<Tacgia> list = dao.getAll();
		for(Tacgia tg : list)
		{
			Object[] row = {tg.getMaTacGia(), tg.getTenTacGia(), tg.getNgaySinh(), tg.getGioiTinh(), tg.getDiaChi()};
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
			txtMatacgia.setText(model.getValueAt(selectedRow, 0).toString());
			txtTentacgia.setText(model.getValueAt(selectedRow, 1).toString());
			txtNgaysinh.setText(model.getValueAt(selectedRow, 2).toString());
			String gt = model.getValueAt(selectedRow, 3).toString();
			if(gt.equals("Nam"))
				rdoNam.setSelected(true);
			else
				rdoNam.setSelected(false);
			txtDiachi.setText(model.getValueAt(selectedRow, 4).toString());
		}
		
		btnBoQua.setEnabled(true);
	}
	
	private void btnThem_Click()
	{
		if(!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
			return;
		ResetValue();
		txtMatacgia.setEnabled(true);
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
		String ma = txtMatacgia.getText().trim();
		String ten = txtTentacgia.getText().trim();
		String dateString = txtNgaysinh.getText().trim();
		String gt;
		String diachi = txtDiachi.getText().trim();
		
		
		if(ma.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập mã tác giả", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(ten.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập tên tác giả", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(dateString.equals(""))
		{
			dateString = "1900-01-01";
		}
		
		if(!DateTimeUtil.isDate(dateString, this))
		{
			return;
		}
		
		if(rdoNam.isSelected())
			gt = "Nam";
		else
			gt = "Nữ";
		
		if(diachi.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập địa chỉ", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Date date = Date.valueOf(dateString);
		
		TacGiaDAO dao = new TacGiaDAO();
		Tacgia key = dao.selectById(ma);
		if(key != null)
		{
			JOptionPane.showMessageDialog(this, "Trùng mã tác giả", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		dao.them(new Tacgia(ma, ten, date, gt, diachi));
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

		if(txtMatacgia.getText().trim().equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu để xóa", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "Xóa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
		{
			String matl = txtMatacgia.getText().trim();
			TacGiaDAO dao = new TacGiaDAO();
			dao.xoa(matl);
			ResetValue();
			GetData(model);
		}
	}
	
	private void btnTimKiem_Click()
	{
		String ma = txtMatacgia.getText();
		String ten = txtTentacgia.getText().trim();
		String diachi = txtDiachi.getText().trim();
		if(ma.length() == 0 && ten.length() == 0 && diachi.length() == 0)
		{
			JOptionPane.showMessageDialog(this, "Vui lòng nhập điều kiện tìm kiếm", "Thông báo", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		TacGiaDAO dao = new TacGiaDAO();
		List<Tacgia> list = dao.getAll();
		
		for(int i = model.getRowCount()-1; i>=0; i--)
			model.removeRow(i);
		
		for(Tacgia t : list)
		{
			if(t.getTenTacGia().toLowerCase().contains(ten.toLowerCase()) && t.getDiaChi().toLowerCase().contains(diachi.toLowerCase()))
			{
				Object[] row = {t.getMaTacGia(), t.getTenTacGia(), t.getNgaySinh(), t.getGioiTinh(), t.getDiaChi()};
				model.addRow(row);
			}
		}
		
		JOptionPane.showMessageDialog(this, "Có " + model.getRowCount() + " dòng thỏa mãn điều kiện", "Thông báo", JOptionPane.PLAIN_MESSAGE);	
	}
	
	private void btnSua_Click()
	{
		if(!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
			return;
		String ma = txtMatacgia.getText();
		String ten = txtTentacgia.getText().trim();
		String dateString = txtNgaysinh.getText().trim();
		String gt;
		String diachi = txtDiachi.getText().trim();
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
			JOptionPane.showMessageDialog(this, "Chưa nhập tên tác giả", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(dateString.equals(""))
		{
			dateString = "1900-01-01";
		}
		
		if(!DateTimeUtil.isDate(dateString, this))
		{
			return;
		}
		
		if(rdoNam.isSelected())
			gt = "Nam";
		else
			gt = "Nữ";
		
		if(diachi.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập địa chỉ", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Date date = Date.valueOf(dateString);
		
		TacGiaDAO dao = new TacGiaDAO();
		dao.sua(new Tacgia(ma, ten, date, gt, diachi));
		ResetValue();
		GetData(model);
	}
	
	private void btnReset_Click()
	{
		GetData(model);
		ResetValue();
	}
	
}
