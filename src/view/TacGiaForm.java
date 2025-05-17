package view;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import dao.TacGiaDAO;
import model.Nhanvien;
import model.Tacgia;
import utilities.DateTimeUtil;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

public class TacGiaForm extends JPanel {

	private static final long serialVersionUID = 1L;
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
		FlatLightLaf.setup();
		
		setBounds(100, 100, 1041, 553);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã tác giả");
		lblNewLabel.setBounds(53, 14, 88, 23);
		lblNewLabel.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblNewLabel);
		
		txtMatacgia = new JTextField();
		txtMatacgia.setBounds(185, 10, 283, 31);
		txtMatacgia.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(txtMatacgia);
		txtMatacgia.setColumns(10);
		
		JLabel lblTnThLoi = new JLabel("Tên tác giả");
		lblTnThLoi.setBounds(536, 14, 93, 23);
		lblTnThLoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnThLoi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblTnThLoi);
		
		txtTentacgia = new JTextField();
		txtTentacgia.setBounds(710, 10, 255, 31);
		txtTentacgia.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtTentacgia.setColumns(10);
		this.add(txtTentacgia);
		
		String[] col = {"Mã tác giả", "Tên tác giả", "Ngày sinh", "Giới tính", "Địa chỉ"};
		model = new DefaultTableModel(null, col);
		lblNgySinh.setBounds(53, 67, 83, 23);
		lblNgySinh.setForeground(new Color(0, 0, 0));
		lblNgySinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgySinh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtNgaysinh.setBounds(185, 63, 283, 31);
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
		this.add(lblNgySinh);
		this.add(txtNgaysinh);
		lblGioitinh.setBounds(536, 67, 67, 23);
		lblGioitinh.setForeground(new Color(0, 0, 0));
		lblGioitinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblGioitinh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblGioitinh);
		rdoNam.setBounds(710, 64, 69, 29);
		rdoNam.setForeground(new Color(0, 0, 0));
		rdoNam.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(rdoNam);
		lblDiachi.setBounds(53, 122, 57, 23);
		lblDiachi.setForeground(new Color(0, 0, 0));
		lblDiachi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiachi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblDiachi);
		txtDiachi.setBounds(185, 118, 283, 31);
		txtDiachi.setToolTipText("");
		txtDiachi.setForeground(new Color(0, 0, 0));
		txtDiachi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		
		this.add(txtDiachi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 180, 641, 332);
		this.add(scrollPane);
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
		panel.setBounds(750, 204, 263, 269);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
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
